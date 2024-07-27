package com.example.demo.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BankSecurityConfig {
	
	static {
		System.out.println("BankSecurityConfig.enclosing_method()");
	}
	
	public BankSecurityConfig() {
		System.out.println("BankSecurityConfig.BankSecurityConfig()");
	}
	
	@Bean
	public SecurityFilterChain customizeFilter(HttpSecurity http)throws Exception {
		
		System.out.println("BankSecurityConfig.customizeFilter()");
		
		http.authorizeHttpRequests(
				(request) ->request.antMatchers("/bank/","/bank/about","/bank/check")
				.permitAll().anyRequest()
				.authenticated())
				.formLogin();
		
		return http.build();
	}
	
}
