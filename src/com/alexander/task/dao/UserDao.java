package com.alexander.task.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.alexander.task.entity.Payment;
import com.alexander.task.entity.User;
import com.alexander.task.exception.DaoException;

public interface UserDao {
    boolean addUser(String firstName, String secondName, String email, int password) 
    		throws DaoException;
    boolean deleteUser(String email, String password) throws DaoException;
    
    User findUserById(int id) throws DaoException;
    List<User> findUserByFirstName(String firstName) throws DaoException;
    List<User> findUserByLastName(String lastName) throws DaoException;
    List<User> findUserByFirstLastName(String firstName, String LastName) throws DaoException;
    List<User> findUserByRole(String role);
    List<User> findUserByPassword(int password) throws DaoException;    
    User findUserByEmail(String email) throws DaoException;
    User findUserByEmailPassword(String email, int password) throws DaoException;
    List<User> findAllUsers() throws DaoException;  
    
    boolean addPayment(int paymentAmount, String date, String time, int userId) throws DaoException;
    boolean removePayment(int paymentAmount) throws DaoException;    
    List<Payment> findPaymentByUser(int userId) throws DaoException;
    List<Payment> findPaymentByDate(LocalDate date) throws DaoException;
    List<Payment> findPaymentByDateRange(LocalDate startDate, LocalDate endDate) throws DaoException;
    List<Payment> findPaymentByDateBefore(LocalDate date) throws DaoException;
    List<Payment> findPaymentByDateAfter(LocalDate date) throws DaoException;
    List<Payment> findPaymentByTime(LocalTime time) throws DaoException;
    List<Payment> findPaymentByTimeRange(LocalTime startTime, LocalTime endTime) throws DaoException;
    List<Payment> findPaymentByTimeBefore(LocalTime time) throws DaoException;
    List<Payment> findPaymentByTimeAfter(LocalTime time) throws DaoException;
    List<Payment> findAllPayment() throws DaoException;  
}
