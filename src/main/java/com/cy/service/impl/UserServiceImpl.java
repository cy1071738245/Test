package com.cy.service.impl;

import com.cy.entity.User;
import com.cy.mapper.UserMapper;
import com.cy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int register(String userName, String password, String realName) {
        return userMapper.register(userName, password, realName);
    }

    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName, password);
    }

}
