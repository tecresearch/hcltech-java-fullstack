package com.security.service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.UserInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails 
{
    private static final long serialVersionUID = 1L;
    
	private String username; // Changed from 'name' to 'username' for clarity
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoDetails(UserInfo userInfo)
    {
    	System.out.println("Userinfo details invoked...");
        this.username = userInfo.getName(); // Assuming 'name' is used as 'username'
        this.password = userInfo.getPassword();
        String role=userInfo.getRoles();
        List<String> roles=List.of(role.split(","));
        this.authorities = roles
        		.stream()
        		.map(r->new SimpleGrantedAuthority("ROLE_"+r))
                .collect(Collectors.toList());
        System.out.println(authorities);
    }
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        return authorities;
    }
    public String getPassword() 
    {
        return password;
    }
    public String getUsername() 
    {
        return username;
    }
    public boolean isAccountNonExpired() 
    {
        return true; // Implement your logic if you need this
    }
    public boolean isAccountNonLocked() 
    {
        return true; // Implement your logic if you need this
    }
    public boolean isCredentialsNonExpired() 
    {
        return true; // Implement your logic if you need this
    }
    public boolean isEnabled() 
    {
        return true; // Implement your logic if you need this
    }
}