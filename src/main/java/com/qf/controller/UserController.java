package com.qf.controller;

import com.qf.Response.UserResponse;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 25849 on 2019/11/27.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll/{size}/{page}")
    public UserResponse findAll(@PathVariable("size")Integer size, @PathVariable("page")Integer page){

        System.out.println("这里是8081的访问");

        return userService.findAll(size,page);
    }

    @RequestMapping("/findOne")
    public User findOne(@RequestBody User user){
        Integer userId = user.getUserId();
        return userService.findById(userId);
    }
    @RequestMapping("/updateuser")
    public User updateuser(@RequestBody User user){

        return userService.saveAndFlush(user);
    }
    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public String deleteById(@RequestBody User user){

        return   userService.deleteById(user);
    }
}
