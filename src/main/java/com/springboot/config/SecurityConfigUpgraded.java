package com.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigUpgraded {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails jack = User.withUsername("jack")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();

        UserDetails sparrow = User.withUsername("sparrow")
                .password(passwordEncoder().encode("password1"))
                .roles("USER")
                .build();

        UserDetails jack_sparrow = User.withUsername("jack_sparrow")
                .password(passwordEncoder().encode("password_jack"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(jack, sparrow, jack_sparrow);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .antMatchers("/nonSecure").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/welcome", "/greeting")
                .authenticated().and().httpBasic().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
