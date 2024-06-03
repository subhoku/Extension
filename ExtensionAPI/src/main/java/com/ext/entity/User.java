package com.ext.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(name = "email",nullable = false, length = 50, unique = true)
    private String email;
     
    @Column(name = "password",nullable = false, length = 64)
    private String password;
    
    @Column(name = "type",nullable = false, length = 10)
    private String type;
    
    @Column(name = "refid",nullable = false)
    private Long refid;
    
    @Column(name = "orgname",nullable = false, length = 255)
    private String orgname;
    
    @Column(name = "fromtbl",nullable = false, length = 255)
    private String fromtbl;
    
    @Column(name = "user_type",nullable = false, length = 50)
    private String uType;
    
    @Column(name = "user_role",nullable = false, length = 10)
    private String uRole;
    
    @Column(name = "profilepic", length = 500)
    private String profilePic;
    
 
    public User() { }
     
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    

	@SuppressWarnings("unused")
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return null;
	}

	@Override
	public String getUsername() {
		return this.email;
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
     
}
