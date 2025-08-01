package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.UserInfo;
import com.security.repository.UserInfoRepository;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired private UserInfoRepository repository;

    @Autowired private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
    	System.out.println("User details service invoked..."+username);
    	UserInfo userInfo = repository.findByName(username);
    	System.out.println("UserInfo object created..."+userInfo);
    	// Converting UserInfo to UserDetails
    	if(userInfo==null)
    		throw new UsernameNotFoundException("User not found: " + username);
    	return new UserInfoDetails(userInfo);
    }
    public String addUser(UserInfo userInfo) 
    {
        // Encode password before saving the user
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User Added Successfully";
    }
}