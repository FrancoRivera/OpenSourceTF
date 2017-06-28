package com.upc.tfap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)//Nos permite escribir anotacion para controlar el acceso a los metodos segun la seguridad
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userService;

	//Servira para añadire el userDetails que se creo con anterioridad
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers( "/", "/about").permitAll()
			.antMatchers( "/usuario/registrar").permitAll() //permitir registrar nuevo usaurio
			.antMatchers("/css/*","/imgs/*", "/js/*", "/fonts/*").permitAll()
			.anyRequest().authenticated()
			.and()
			
			.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
			.usernameParameter("identity_number_person").passwordParameter("password_person")
			.defaultSuccessUrl("/login/loginsuccess").permitAll()
			.and()
			
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
			.permitAll();
		
	}

}
