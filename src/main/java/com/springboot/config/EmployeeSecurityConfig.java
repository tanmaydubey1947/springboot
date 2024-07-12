package com.springboot.config;


import com.springboot.filter.JwtAuthFilter;
import com.springboot.service.EmployeeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EmployeeSecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

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
//        return http.csrf().disable()
//                .authorizeHttpRequests()
//                .antMatchers("/employees/welcome", "/employees/create", "/employees/authenticate").permitAll()
//                .and()
//                .authorizeHttpRequests().antMatchers("/employees/**")
//                .authenticated().and().httpBasic().and().build();

        return http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/employees/welcome", "/employees/create", "/employees/authenticate").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/employees/**")
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
