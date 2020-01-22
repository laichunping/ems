package com.fjrxny.ems.service;

import com.fjrxny.ems.pojo.User;

public interface UserService {

    public User login(User user);

    public User selectOne(User user);

}
