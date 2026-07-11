package com.naresh.day004.service;

import com.naresh.day004.model.User;

public interface LoginService {

    /**
     * Authenticate user.
     *
     * @param username Login username
     * @param password Login password
     * @return Authenticated User
     */
    User login(String username, String password);

}
