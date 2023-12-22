package com.bootsample.service;

import java.util.Optional;

import com.bootsample.model.UserDto;

public interface UserService {
    Optional<UserDto> login(UserDto userVo) throws Exception;
}