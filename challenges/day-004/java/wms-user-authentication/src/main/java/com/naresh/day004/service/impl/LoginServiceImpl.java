package com.naresh.day004.service.impl;

import com.naresh.day004.dao.UserDAO;
import com.naresh.day004.dao.impl.UserDAOImpl;
import com.naresh.day004.model.User;
import com.naresh.day004.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO;

    public LoginServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public User login(String username, String password) {

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }

        return userDAO.authenticateUser(username, password);
    }
}
