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
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/", "/home", "login").permitAll() // Allow access to these path without authentication
                .anyRequest().authenticated()) // Require authentication for any request
            .formLogin(form -> form
                .loginPage("/login") // Custom login page
                .defaultSuccessUrl("/home", true) // Redirect to /home upon successful login
                .permitAll()) // Allow everyone to access the login page
            .logout(logout -> logout
                    .logoutSuccessUrl("/login")) // Redirect to /login upon successful logout
            .csrf(csrf -> csrf.disable()); // Disable CSRF protection for this example
        return http.build(); // Build and return the SecurityFilterChain
    }
    /**
     * This refactoring aligns with the latest Spring Security practices,
     * ensuring compatibility with Spring Security 5.4 and later versions.
     */


    /*protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").defaultSuccessUrl("/home")
                .and()
            .logout();
    }*/
}
