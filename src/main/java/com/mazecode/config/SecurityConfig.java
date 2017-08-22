package com.mazecode.config;

import com.mazecode.web.handler.CustomAuthenticationFailureHandler;
import com.mazecode.web.handler.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
//		http.csrf().disable();
		http
		// Resources
		.authorizeRequests().antMatchers("/css/**", "/js/**", "/image/**", "/resources/**").permitAll().and()		
		// URI
		.authorizeRequests().antMatchers("/login").permitAll().and()
		.authorizeRequests().antMatchers("/admin**").hasRole("ADMIN").and()
		.authorizeRequests().antMatchers("/**").hasRole("USER").and()
		.authorizeRequests().antMatchers("/api/**").hasAnyRole("USER","ADMIN").and()		
		// Login
		.formLogin().loginPage("/login").successHandler(customAuthenticationSuccessHandler).failureHandler(customAuthenticationFailureHandler).and()
		// Access Denied
		.exceptionHandling().accessDeniedPage("/accessDenied").and()
		// Logout
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout-success").deleteCookies("mazecode-cookie");		
//		http.httpBasic().realmName("MAZECODE-APP");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//TODO: Enable when we are using encrypted passwords
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		auth.userDetailsService(userDetailsService);
	}
}
