package com.naresh.day004.dao;

import java.util.List;

import com.naresh.day004.model.User;

public interface UserDAO {

    /**
     * Authenticate user using username and password.
     *
     * @param username Login username
     * @param password Login password
     * @return User object if authentication succeeds,
     *         otherwise null.
     */
    User authenticateUser(String username, String password);


    /**
     * Create new user
     *
     * @param user User object
     * @return true if user created successfully
     */
    boolean createUser(User user);


    /**
     * Find user by user id
     *
     * @param userId User primary key
     * @return User object
     */
    User findById(int userId);


    /**
     * Fetch all users
     *
     * @return List of users
     */
    List<User> findAll();


    /**
     * Update existing user
     *
     * @param user User object
     * @return true if updated successfully
     */
    boolean updateUser(User user);


    /**
     * Delete user by id
     *
     * @param userId User primary key
     * @return true if deleted successfully
     */
    boolean deleteUser(int userId);

}
