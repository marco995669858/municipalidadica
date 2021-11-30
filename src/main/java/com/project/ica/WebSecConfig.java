package com.project.ica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.ica.security.UserService;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService service;
	
	@Autowired
	private Securityhandler securityhandler;

	@Bean
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/Principal/*").authenticated()
		.antMatchers("/Empleos/*").authenticated()
		.antMatchers("/datos/*").authenticated()
		.antMatchers("/nosotros/*").authenticated()
		.antMatchers("/consultas/*").authenticated()
		.antMatchers("/buzon/*").authenticated()
		.antMatchers("/rol/*").authenticated()
		.antMatchers("/Permisos/*").authenticated()
		.antMatchers("/Empleos/*").authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.usernameParameter("username")
        .passwordParameter("password")
        .successHandler(securityhandler)
	.and().headers().frameOptions().sameOrigin();
	}

}
