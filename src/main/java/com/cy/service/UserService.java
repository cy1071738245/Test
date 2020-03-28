package com.cy.service;

import com.cy.entity.User;

public interface UserService {

    int register(String userName, String password, String realName);

    User login(String userName, String password);

}
