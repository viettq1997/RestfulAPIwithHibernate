package com.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Disable CSRF (cross site request forgery)
		http.csrf().disable();

		// No session will be created or used by spring security
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Entry points
		http.authorizeRequests()//

				// http://localhost:8080/Staff/list1
				.antMatchers(HttpMethod.GET, "/User/**").permitAll().antMatchers(HttpMethod.GET, "/User/checkLogIn2/**")
				.permitAll().antMatchers(HttpMethod.GET, "/New/**").permitAll().antMatchers(HttpMethod.GET, "/Staff/**")
				.permitAll().antMatchers(HttpMethod.GET, "/Project/**").permitAll()
				.antMatchers(HttpMethod.GET, "/reports/**").permitAll().antMatchers(HttpMethod.GET, "/Request/**")
				.permitAll().antMatchers(HttpMethod.GET, "/timesheet/**").permitAll()
				.antMatchers(HttpMethod.GET, "/bugs/**").permitAll().antMatchers(HttpMethod.GET, "/slide/**")
				.permitAll().
				// Disallow everything else..
				anyRequest().authenticated();

		// If a user try to access a resource without having enough permissions
		http.exceptionHandling().accessDeniedPage("/Login");

		// Apply JWT
		http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

		// Optional, if you want to test the API from a browser
		// http.httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Allow swagger to be accessed without authentication
		web.ignoring().antMatchers("/v2/api-docs")//
				.antMatchers("/swagger-resources/**")//
				.antMatchers("/swagger-ui.html")//
				.antMatchers("/configuration/**").antMatchers("/webjars/**")//
				.antMatchers("/public");//
	}

}