package org.example.ch15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * migrate from using WebSecurityConfigurerAdapter to defining a SecurityFilterChain bean
 * for configuring HTTP security. This is because WebSecurityConfigurerAdapter is deprecated
 * in newer versions of Spring Security.
 */
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequest -> authorizeRequest
                .anyRequest().authenticated()) // Require authentication for any request
            .formLogin(form -> form
                .loginPage("/login.html") // Custom login page
                .permitAll()) // Allow everyone to access the login page
            .csrf(csrf -> csrf.disable()); // Disable CSRF protection for this example
        return http.build(); // Build the SecurityFilterChain
    }
    /**
     * This refactoring aligns with the latest Spring Security practices,
     * ensuring compatibility with Spring Security 5.4 and later versions.
     */
}
