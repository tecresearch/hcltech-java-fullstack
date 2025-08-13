package com.hcl.controller;
import com.hcl.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController 
{


    @GetMapping("/welcome")
    public String welcome() 
    {
        return "Welcome this endpoint is not secure";
    }
    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User user)
    {
        System.out.println("auth: "+user);
        return "";
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


    @PostMapping("/logout-session")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // Handle logout logic (if any)
        request.getSession().invalidate(); // Invalidate the session
        return ResponseEntity.ok().body("Logout successful");
    }
}