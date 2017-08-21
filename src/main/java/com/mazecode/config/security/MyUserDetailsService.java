package com.mazecode.config.security;


import com.mazecode.dao.UserDao;
import com.mazecode.model.Roles;
import com.mazecode.model.Users;
import com.mazecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Service("userDetailsService")
//@Transactional
//public class MyUserDetailsService implements UserDetailsService {
public class MyUserDetailsService  {

//	@Autowired
//	private UserDao userDao;
//
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Users user = userDao.findById(username);
//
//		if (user == null) {
//			throw new UsernameNotFoundException("Invalid username or password");
//		}
//
//		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getEnabled(), true, true, !user.getLocked(), getAuthorities(user));
//
//	}
//
//	private List<GrantedAuthority> getAuthorities(Users user) {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//
//		for (Roles role : user.getRoleses()) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
//
//		return authorities;
//	}
}
