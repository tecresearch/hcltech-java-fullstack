package com.security.controller;
import com.security.entity.AuthRequest;
import com.security.entity.UserInfo;
import com.security.service.JwtService;
import com.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController 
{
    @Autowired private UserInfoService service;
    @Autowired private JwtService jwtService;
    @Autowired private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() 
    {
        return "Welcome this endpoint is not secure";
    }
    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) 
    {
        return service.addUser(userInfo);
    }
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() 
    {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() 
    {
    	System.out.println("Admin profile handler invoked...");
        return "Welcome to Admin Profile";
    }

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) 
    {
    	System.out.println("Login handler invoked..."+authRequest.getUsername());
        Authentication authentication = authenticationManager
        		.authenticate(new UsernamePasswordAuthenticationToken(authRequest
        				.getUsername(), authRequest.getPassword())
        );
        System.out.println("Autentication:"+authentication.isAuthenticated());
        if(authentication.isAuthenticated()) 
        {
            return jwtService.generateToken(authRequest.getUsername());
        }
        else 
        {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}