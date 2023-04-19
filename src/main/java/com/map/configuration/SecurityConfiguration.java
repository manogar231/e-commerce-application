//package com.map.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.map.customedetailsservice.CustomUserDetailService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//
//	  @Autowired
//	    private CustomUserDetailService userDetailService;
//
//
//	    @Bean
//	    PasswordEncoder passwordEncoder (){
//
//	        return new BCryptPasswordEncoder();
//	    }
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	                .csrf().disable()
//	                .authorizeRequests()
//	                .antMatchers(HttpMethod.POST, "user/**").permitAll()
//	                .antMatchers(HttpMethod.GET,"user/**").permitAll()
//	                .antMatchers("/h2-console").permitAll()
//	                .antMatchers(HttpMethod.GET,"/product/allproduct").permitAll()
//	                .antMatchers(HttpMethod.POST,"/product/**").permitAll()
//	                .anyRequest()
//	                .authenticated()
//	                .and()
//	                .formLogin();
//	              
//	    }
//
//	    @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailService)
//	                .passwordEncoder(passwordEncoder());
//
//	    }
//
//	    @Override
//	    @Bean
//	    public AuthenticationManager authenticationManagerBean() throws Exception {
//	        return super.authenticationManagerBean();
//	    }
//}
