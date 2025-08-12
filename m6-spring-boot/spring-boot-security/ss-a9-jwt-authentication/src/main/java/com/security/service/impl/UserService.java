package com.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repository.UserInfoRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        System.out.println("User details service invoked..."+username);
        User user = repository.findByName(username);
        System.out.println("UserInfo object created..."+ user.getName());
        // Converting UserInfo to UserDetails
        if(user ==null) {
            System.out.println("User not found..." + user.getName());
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new UserInfoDetails(user);
    }
    public String addUser(User user)
    {
        // Encode password before saving the user
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getName());
        System.out.println(user.getRoles());
        User u=repository.save(user);
        System.out.println(u.getName());
        System.out.println(u.getRoles());
        return "User Added Successfully";
    }

}