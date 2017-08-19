package com.mazecode.config;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private AppUserDetailsService            appUserDetailsService;
//	@Autowired
//	private AppBasicAuthenticationEntryPoint appBasicAuthenticationEntryPoint;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//				.authorizeRequests()
//				.antMatchers("/user/**")
//				.hasAnyRole("ADMIN", "USER")
//				.and().httpBasic().realmName("MAZECODE-APP")
//				.authenticationEntryPoint(appBasicAuthenticationEntryPoint);
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder);
//	}
}
