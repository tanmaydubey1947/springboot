package com.springboot.config;


import com.springboot.service.EmployeeUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EmployeeSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails jack = User.withUsername("jack")
//                .password(passwordEncoder().encode("password"))
//                .roles("HR")
//                .build();
//
//        UserDetails sparrow = User.withUsername("sparrow")
//                .password(passwordEncoder().encode("password1"))
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails jack_sparrow = User.withUsername("jack_sparrow")
//                .password(passwordEncoder().encode("password_jack"))
//                .roles("EMPLOYEE", "HR", "MANAGER")
//                .build();
//
//        return new InMemoryUserDetailsManager(jack, sparrow, jack_sparrow);

        return new EmployeeUserDetailsService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/employees/welcome", "/employees/create").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/employees/**")
                .authenticated().and().httpBasic().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
