package com.mazecode.service;


import com.mazecode.dao.UserDao;
import com.mazecode.model.Roles;
import com.mazecode.model.Users;
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

/**
 * @author mazecode
 */

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {
	
	
	@Autowired
	UserDao userDao;
	
	/**
	 * Method to return UserDetails after successful login
	 *
	 * @param username
	 * @return UserDetails object
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDao.findById(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getEnabled(), true, true, !user.getLocked(), getAuthorities(user));
		
	}
	
	private List<GrantedAuthority> getAuthorities(Users user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (Roles role : user.getRoleses()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return authorities;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Users> all() {
		List<Users> users = userDao.findAll();
		return  users;
	}
	
	@Transactional(readOnly = false)
	@Override
	public void saveLastLoginDate(String username) {
		Users user = userDao.findById(username);
		user.setLastLoginDate(new Date());
		userDao.save(user);
		
	}
	
	@Override
	public Users getUser(String username) {
		return userDao.findById(username);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void saveUser(Users user) {
		userDao.save(user);
		
	}
	
	
}
