package com.alexander.task.dao.impl;

import com.alexander.task.dao.pool.ConnectionPool;
import com.alexander.task.dao.UserDao;
import com.alexander.task.exception.DaoException;
import com.alexander.task.entity.Payment;
import com.alexander.task.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class UserDaoImpl implements UserDao {
	private static final String ADD_USER = "INSERT INTO users (email, password, first_name, second_name, role_id) VALUES (?, ?, ?, ?, 1)"; 
	private static final String FIND_USER_FIRST_NAME = "SELECT first_name FROM users WHERE email=? AND password=?";
	private static final String FIND_USER_SECOND_NAME = "SELECT second_name FROM users WHERE email=? AND password=?";
	private static final String FIND_USER_BY_EMAIL_PASSWORD = "SELECT user_id, first_name, second_name FROM users WHERE email=? and password=?";
	private static final String FIND_USER_ID = "SELECT id FROM users WHERE email=? AND password=?";	
	
    @Override
    public boolean addUser(String firstName, String secondName, String email, int password) throws DaoException {
    	boolean isAdded;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        try {
        	connection = pool.getConnection();
            PreparedStatement addStatement = connection.prepareStatement(ADD_USER);
            addStatement.setString(1, email);
            addStatement.setInt(2, password);
            addStatement.setString(3, firstName);
            addStatement.setString(4, secondName);
            isAdded = addStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DaoException("user not added", e);
        } finally {
        	if (pool != null) {
        		pool.backConnection(connection);        
        	}
        }
        return isAdded;
    }   

	@Override
	public User findUserByEmailPassword(String email, int password) throws DaoException {	
		User user = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        try {
        	connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_EMAIL_PASSWORD);
            statement.setString(1, email);
            statement.setInt(2, password);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
            	int id = result.getInt(1);
            	String firstName = result.getString(2);
            	String secondName = result.getString(3);
            	user = new User(id, firstName, secondName, email, password);
            }
        } catch (SQLException e) {
            throw new DaoException("user not found", e);
        } finally {
        	if (pool != null) {
        		pool.backConnection(connection);        
        	}
        }
        return user;
	}

	@Override
	public boolean deleteUser(String email, String password) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByFirstName(String firstName) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByLastName(String lastName) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByFirstLastName(String firstName, String LastName) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByPassword(int password) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPayment(int paymentAmount, String date, String time, int userId) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePayment(int paymentAmount) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Payment> findPaymentByUser(int userId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByDate(LocalDate date) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByDateRange(LocalDate startDate, LocalDate endDate) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByDateBefore(LocalDate date) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByDateAfter(LocalDate date) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByTime(LocalTime time) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByTimeRange(LocalTime startTime, LocalTime endTime) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByTimeBefore(LocalTime time) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findPaymentByTimeAfter(LocalTime time) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findAllPayment() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
