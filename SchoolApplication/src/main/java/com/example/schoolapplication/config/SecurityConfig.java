//package com.example.schoolapplication.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(customer-> customer.disable());
//        http.authorizeHttpRequests(
//                authorizeRequests ->authorizeRequests.requestMatchers("/login")
//                                                                                    .permitAll()
//                                                                                    .anyRequest()
//                                                                                    .authenticated());
//        http.httpBasic(Customizer.withDefaults());
//        http.formLogin(Customizer.withDefaults());
//        return http.build();
//    }
//}
