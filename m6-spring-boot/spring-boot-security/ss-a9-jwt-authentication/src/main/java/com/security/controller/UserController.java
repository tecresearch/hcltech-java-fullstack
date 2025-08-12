package com.security.controller;
import com.security.entity.AuthRequest;
import com.security.entity.User;
import com.security.service.JwtService;
import com.security.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired private UserService service;
    @Autowired private JwtService jwtService;
    @Autowired private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() 
    {
        return "Welcome this endpoint is not secure";
    }
    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User user)
    {
        System.out.println("auth: "+user);
        return service.addUser(user);
    }
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() 
    {
        System.out.println("User profile handler invoked...");
        return "Welcome to authenticated User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() 
    {
    	System.out.println("Admin profile handler invoked...");
        return "Welcome to authenticated Admin Profile";
    }

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) 
    {

        System.out.println("auth"+authRequest);

    	System.out.println("Login handler invoked... to login and generate jwt token...");

        /**
         * Here we authenticate the username and password
         */
        Authentication authentication = authenticationManager
        		.authenticate(new UsernamePasswordAuthenticationToken(authRequest
        				.getUsername(), authRequest.getPassword())
        );
//        authentication.setAuthenticated(true);
        if(authentication.isAuthenticated()) 
        {
            return jwtService.generateToken(authRequest.getUsername());
        }
        else 
        {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    @PostMapping("/logout-session")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // Handle logout logic (if any)
        request.getSession().invalidate(); // Invalidate the session
        return ResponseEntity.ok().body("Logout successful");
    }
}