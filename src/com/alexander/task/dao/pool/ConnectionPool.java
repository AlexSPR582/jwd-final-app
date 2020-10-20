package com.alexander.task.dao.pool;

import com.alexander.task.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {	
    private static ConnectionPool instance;

    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenAwayConnections;

    private final static int POOL_SIZE = 40;

    private ConnectionPool() {
        freeConnections = new LinkedBlockingQueue<>(POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();
    }

    public static ConnectionPool getInstance() throws DaoException {
        if (instance == null) {
            instance = new ConnectionPool();
            instance.init();
        }
        return instance;
    }

    private void init() throws DaoException {
    	Properties properties = new Properties();
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		properties.put("user", "root");
    		properties.put("password", "1234");
    		properties.put("verifyServerCertificate", "false");
    		properties.put("useSSL", "false");
    		properties.put("requireSSL", "false");
    		properties.put("useLegacyDatetimeCode", "false");
    		properties.put("serverTimezone", "UTC");
    		String url = "jdbc:mysql://localhost/hotel";
			for (int i = 0; i < POOL_SIZE; i++) {
				freeConnections.add(new ProxyConnection(DriverManager.getConnection(url, properties)));
			}		
		} catch (SQLException e) {			
			throw new DaoException("problems with connection", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
    }

    public ProxyConnection getConnection() throws DaoException {
        ProxyConnection connection;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            throw new DaoException("Get connection exception", e);
        }
        return connection;
    }

    public void backConnection (Connection connection) {
    	if (connection.getClass().getName().equals("ProxyConnection")) {
    		givenAwayConnections.remove(connection);
            freeConnections.offer((ProxyConnection)connection);
    	}
    }

    public void destroyPool () throws DaoException {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (InterruptedException e) {
                throw new DaoException("Destroy pool exception");
            }
        }
        deregisterConnections();
    }

    private void deregisterConnections() { //todo
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
