package com.alexander.task.dao;

import com.alexander.task.dao.impl.HotelDaoImpl;
import com.alexander.task.dao.impl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory() {}

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public HotelDaoImpl getHotelDao() {
        return new HotelDaoImpl();
    }
}
