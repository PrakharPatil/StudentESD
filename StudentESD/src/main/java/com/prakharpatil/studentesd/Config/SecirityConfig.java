package com.prakharpatil.studentesd.Config;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecirityConfig {

    @Bean
    public DefaultSecurityFilterChain securityChainFilter(HttpSecurity http) throws Exception {
        return http
                .csrf(Customizer -> Customizer.disable())
//                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        return new InMemoryUserDetailsManager(
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build(),
//                User.withDefaultPasswordEncoder()
//                        .username("admin")
//                        .password("password")
//                        .roles("USER", "ADMIN")
//                        .build());
//    }
}
