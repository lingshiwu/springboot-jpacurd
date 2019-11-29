package com.qf.respository;

import com.qf.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 25849 on 2019/11/27.
 */
public interface UserRespository extends JpaRepository<User,Integer> {
}
