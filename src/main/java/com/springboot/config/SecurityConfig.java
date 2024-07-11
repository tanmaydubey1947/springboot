//package com.springboot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("jack")
//                .password(passwordEncoder().encode("password"))
//                .roles("ADMIN");
//
//        auth.inMemoryAuthentication()
//                .withUser("sparrow")
//                .password(passwordEncoder().encode("password1"))
//                .roles("USER");
//
//        auth.inMemoryAuthentication()
//                .withUser("jack_sparrow")
//                .password(passwordEncoder().encode("password_jack"))
//                .roles("USER", "ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/nonSecure").permitAll()
//                .and()
//                .authorizeHttpRequests().antMatchers("/welcome", "/greeting")
//                .authenticated().and().httpBasic();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}