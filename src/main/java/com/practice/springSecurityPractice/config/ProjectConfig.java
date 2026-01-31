package com.practice.springSecurityPractice.config;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("John")
                .password("{noop}12345")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(@NonNull HttpSecurity http) throws Exception{
        http.httpBasic(Customizer.withDefaults());
        http.cors(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        UserDetails user = User.withUsername("Jane")
                .password("{noop}12345")
                .authorities("read")
                .build();
        UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user);
        http.userDetailsService(userDetailsService);
        return http.build();
    }
}
