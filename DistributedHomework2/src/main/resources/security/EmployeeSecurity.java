package com.example.distributedhomework2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(2)
@EnableWebSecurity
@Configuration
public class EmployeeSecurity extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll();

//        http
//                .antMatcher("/user/**")
//
//                .authorizeRequests()
//                .antMatchers("/user/{userID}").access("@myUserDetailsService.checkUserID(authentication, #userID)")
//                .antMatchers("/user/info/{userID}").access("@myUserDetailsService.checkUserID(authentication, #userID)")
//
//                .and()
//                .formLogin()
//                .loginPage("/loginpage")
//                .loginProcessingUrl("/user/login")
//
//                .successHandler(new CustomAuthenticationSuccessHandler())
//                .failureHandler(new CustomAuthenticationFailureHandler())
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/user/logout")
//                .logoutSuccessUrl("/loginpage")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/access-denied")
//                .and()
//                .csrf().disable();


    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
