package com.alexander.task.dao.impl;

import com.alexander.task.dao.HotelDao;
import com.alexander.task.exception.DaoException;
import com.alexander.task.entity.Hotel;

import java.util.List;

public class HotelDaoImpl implements HotelDao {
    @Override
    public List<Hotel> findHotelByCountry(String country) throws DaoException {
        return null;
    }

    @Override
    public List<Hotel> findHotelByCity(String city) throws DaoException {
        return null;
    }

    @Override
    public List<Hotel> findHotelByAddress(String address) throws DaoException {
        return null;
    }

    @Override
    public List<Hotel> findHotelByType(String type) throws DaoException {
        return null;
    }

    @Override
    public List<Hotel> findHotelByStars(String stars) throws DaoException {
        return null;
    }

    @Override
    public boolean addHotel(Hotel hotel) throws DaoException {
        return false;
    }

    @Override
    public boolean removeHotel(Hotel hotel) throws DaoException {
        return false;
    }
}
