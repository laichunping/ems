package com.fjrxny.ems.service.impl;

import com.fjrxny.ems.mapper.UserMapper;
import com.fjrxny.ems.pojo.User;
import com.fjrxny.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public User login(User user) {
        return userMapper.verifyUser(user);
    }

    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }
}
