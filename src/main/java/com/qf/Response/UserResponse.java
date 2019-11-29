package com.qf.Response;

import com.qf.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * Created by 25849 on 2019/11/27.
 */
@Data
public class UserResponse {

    private List<User> list;

    private Integer page;

    private Long total;

}
