//package com.afi.tp_spring1.security;
//
//import org.springframework.context.annotation.*;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.*;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class Security_Config {
//	@Bean
//    public UserDetailsService userDetailsService() {
//        return new Custom_Etudiant();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//     
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//            .csrf().disable() // utile en dev, à retirer en prod
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/login", "/register", "/save", "/liste", "/css/**", "/js/**").permitAll()
//                .requestMatchers("/listEtudiant", "/rechercher/nom").authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/login") 
//                .usernameParameter("email") 
//        	    .passwordParameter("password")
//                .defaultSuccessUrl("/listEtudiant", true)
//                .failureUrl("/login?error=true")
//                .permitAll()
//            )
//            .logout(logout -> logout.permitAll())
//            .build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//}
