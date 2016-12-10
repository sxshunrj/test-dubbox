package com.sxshunrj.test.dubbo.service.impl;

import com.sxshunrj.test.dubbo.dto.UserDto;
import com.sxshunrj.test.dubbo.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sunxs on 2016/12/10.
 */
@Path("user")
public class UserServiceImpl implements UserService {

    //模拟数据库
    private static List<UserDto> users;
    static {
        users = Collections.synchronizedList(new ArrayList<UserDto>());
        users.add(new UserDto(1,"a"));
        users.add(new UserDto(2,"b"));
    }

    @Override
    @GET
    @Path("{id:\\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public UserDto getUser(@PathParam("id") Long id) {
        for (UserDto user: users){
            if(user.getId() == id){
                System.out.println("根据id["+id+"]，获得到用户信息为["+user.toString()+"]");
                return user;
            }
        }
        System.out.println("根据id["+id+"]，没有获取到用户信息，返回null");
        return null;
    }

    @Override
    @GET
    @Path("save")
    @Consumes({MediaType.APPLICATION_JSON})
    public boolean saveUser(UserDto user) {
        boolean result = users.add(user);
        System.out.println("保存["+user.toString()+"]的结果为["+result+"]");
        return result;
    }

    @Override
    public List<UserDto> getAllUser() {
        System.out.println("获取到所有用户信息为["+users+"]");
        return users;
    }
}
