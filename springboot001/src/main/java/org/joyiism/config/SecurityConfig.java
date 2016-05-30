package org.joyiism.config;

import org.joyiism.filter.XSSFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter characterEncodingFilter = 
				new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		http.addFilterBefore(characterEncodingFilter, CsrfFilter.class);
		http.addFilterBefore(new XSSFilter(), CsrfFilter.class);
		http
	    .authorizeRequests()
	        .antMatchers("/**", "/resources/**").permitAll()
	        .and()
	    .logout()
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/")
	        .and()
	    .csrf().disable()
	    .httpBasic();
	}
}
