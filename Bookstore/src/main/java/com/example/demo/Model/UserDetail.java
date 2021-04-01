package com.example.demo.Model;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 

public class UserDetail implements UserDetails {
    private User user;
     
    public UserDetail(User user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getEmail();
    }
    public String getFirstName() {
    	return user.getFirstName();
    }
    
    public String getLastName() {
    	return user.getLastName();
    }
    
    public String getFullname() {
    	System.out.println(user.getFirstName());
    	return user.getFirstName();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public User getUser() {
    	return this.user;
    	
    }
   

    
}