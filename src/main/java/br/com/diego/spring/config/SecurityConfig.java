package br.com.diego.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	private static final String[] PUBLIC_MATHERS = { //ARRAY DOS ENDPOINT QUE SERÁ PERMITIDO
			"/pessoa/**"
	}; 
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{ //CONFIG BÁSICA SPRING SECURITY
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers(PUBLIC_MATHERS).permitAll()
			.anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		return http.build();
	}

}
