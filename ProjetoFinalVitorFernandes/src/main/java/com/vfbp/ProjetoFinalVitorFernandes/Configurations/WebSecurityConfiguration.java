package com.vfbp.ProjetoFinalVitorFernandes.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vfbp.ProjetoFinalVitorFernandes.Services.PessoaDetailsService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PessoaDetailsService personDetaislService;
	
	@Bean
	AuthenticationProvider AuthenticationProvider() { //https://bcrypt-generator.com/
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(personDetaislService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return provider;
		
	}
	
	@Override
	protected void configure(HttpSecurity http )throws Exception {
		http
			//.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/home").hasAuthority("USER")
			.antMatchers("/produtos").hasAuthority("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

}
