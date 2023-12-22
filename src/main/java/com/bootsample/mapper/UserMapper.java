package com.bootsample.mapper;

import java.util.Optional;

import com.bootsample.model.UserDto;

public interface UserMapper {
    Optional<UserDto> login(UserDto userDto) throws Exception;

}