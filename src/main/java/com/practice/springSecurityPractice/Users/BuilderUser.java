package com.practice.springSecurityPractice.Users;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BuilderUser{

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    UserDetails user = User.withUsername("Rita")
            .password("1234")
            .authorities("READ","ADMIN")
            .accountExpired(false)
            .credentialsExpired(false)
            .disabled(false)
            .build();

    User.UserBuilder builder1 = User.withUsername("Yuta");

    UserDetails u1 = builder1
            .password("1234")
            .authorities("READ","READ_ONLY")
            .passwordEncoder(p -> passwordEncoder.encode(p))
            .credentialsExpired(false)
            .disabled(false)
            .build();
}
