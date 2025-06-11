package com.mickaelsantos.apiagrosync.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFarmFilter securityFarmFilter;

    @Autowired
    private SecurityFieldFilter securityFieldFilter;

    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/farm/create").permitAll()
                            .requestMatchers("/api/v1/field/create").permitAll()
                            .requestMatchers("/api/v1/user/create").permitAll()
                            .requestMatchers("/api/v1/user/delete/{id}").permitAll()
                            .requestMatchers("/api/v1/user/update").permitAll()
                            .requestMatchers("/api/v1/user/auth").permitAll()
                            .requestMatchers("/api/v1/admin/auth").permitAll();

                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(securityFarmFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(securityFieldFilter, BasicAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}