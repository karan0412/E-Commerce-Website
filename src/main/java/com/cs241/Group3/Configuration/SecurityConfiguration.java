package com.cs241.Group3.Configuration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cs241.Group3.Service.UserService;
import com.cs241.Group3.Service.UserServiceImpl;
import com.cs241.Group3.Service.ClothesService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Bean 
	public BCryptPasswordEncoder passwordEncoder()
	{
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder;
	}
	@Bean 
	public UserDetailsService userService()
	{
		return new UserService();
	}
	@Bean 
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.httpBasic().disable();
		http.authorizeRequests()
		.antMatchers("/SellerForm").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/SignIn")
		.usernameParameter("email")
		.defaultSuccessUrl("/HomePage")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/SignIn?logout")
		
		.permitAll();
		

	}
}

