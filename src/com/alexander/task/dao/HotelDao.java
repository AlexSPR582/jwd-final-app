package com.alexander.task.dao;

import com.alexander.task.entity.Hotel;
import com.alexander.task.exception.DaoException;

import java.util.List;

public interface HotelDao {
    List<Hotel> findHotelByCountry(String country) throws DaoException;
    List<Hotel> findHotelByCity(String city) throws DaoException;
    List<Hotel> findHotelByAddress(String address) throws DaoException;
    List<Hotel> findHotelByType(String type) throws DaoException;
    List<Hotel> findHotelByStars(String stars) throws DaoException;   
    boolean addHotel(Hotel hotel) throws DaoException;
    boolean removeHotel(Hotel hotel) throws DaoException;
}
