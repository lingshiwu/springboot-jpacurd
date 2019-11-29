package com.qf.service.impl;

import com.qf.Response.UserResponse;
import com.qf.pojo.User;
import com.qf.respository.UserRespository;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by 25849 on 2019/11/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;





    @Override
    public UserResponse findAll(Integer size, Integer page) {
        if (page<0){
            page=0;
        }else {
            page=page-1;
        }

        Pageable pages= PageRequest.of(page,size);
        Page<User> all = userRespository.findAll(pages);
        List<User> content = all.getContent();
        UserResponse ur=new UserResponse();
        ur.setList(content);
        ur.setTotal(all.getTotalElements());
        ur.setPage(all.getTotalPages());

        return ur;
    }

    @Override
    public User findById(Integer userId) {
        Optional<User> byId = userRespository.findById(userId);
        User user=null;
        if (byId.isPresent()){
            user=byId.get();
        }
        return user;
    }

    @Override
    public User saveAndFlush(User user) {
        return userRespository.saveAndFlush(user);
    }

    @Override
    public String deleteById(User user) {
        try{
            userRespository.deleteById(user.getUserId());
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "fail";
    }
}
