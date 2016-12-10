package com.sxshunrj.test.dubbo.service;
import com.sxshunrj.test.dubbo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUser(Long id);
    boolean saveUser(UserDto user);
    List<UserDto> getAllUser();
}