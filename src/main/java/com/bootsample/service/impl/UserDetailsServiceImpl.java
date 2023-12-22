package com.bootsample.service.impl;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.bootsample.mapper.SelectSampleMapper;
import com.bootsample.model.UserDetailsDto;
import com.bootsample.model.UserDto;

//import lombok.RequiredArgsConstructor;

import com.bootsample.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Transactional
//@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService us) {
        this.userService = us;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    	UserDetails result = null;
    	try {
	        UserDto userDto = UserDto
	                .builder()
	                .userId(userId)
	                .build();
	
	        // 사용자 정보가 존재하지 않는 경우
	        if (userId == null || userId.equals("")) {
	        	result = userService.login(userDto)
	                    .map(u -> new UserDetailsDto(u, Collections.singleton(new SimpleGrantedAuthority(u.getUserId()))))
	                    .orElseThrow(() -> new AuthenticationServiceException(userId));
	        }
	        // 비밀번호가 맞지 않는 경우
	        else {
	        	result = userService.login(userDto)
	                    .map(u -> new UserDetailsDto(u, Collections.singleton(new SimpleGrantedAuthority(u.getUserId()))))
	                    .orElseThrow(() -> new BadCredentialsException(userId));
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    }

}