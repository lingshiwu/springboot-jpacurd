package com.qf.service;

import com.qf.Response.UserResponse;
import com.qf.pojo.User;

import java.util.List;

/**
 * Created by 25849 on 2019/11/27.
 */
public interface UserService {

    public UserResponse findAll(Integer size, Integer page);

    public User findById(Integer userId);

    public User saveAndFlush(User user);

    public String deleteById(User user);
}
