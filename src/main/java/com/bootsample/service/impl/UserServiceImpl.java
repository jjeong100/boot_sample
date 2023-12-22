package com.bootsample.service.impl;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootsample.mapper.UserMapper;
import com.bootsample.model.UserDto;
import com.bootsample.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper mapper;


    /**
     * 로그인 구현체
     *
     * @param userDto UserDto
     * @return Optional<UserDto>
     */
    @Override
    public Optional<UserDto> login(UserDto userDto) throws Exception {
    	Optional<UserDto> result = mapper.login(userDto);
        return result;
    }
}