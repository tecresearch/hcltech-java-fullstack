package com.cts.security;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)  // Enable @PreAuthorize for controller methods
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//        	.cors(cors -> cors.configurationSource(corsConfigurationSource()))
//            .csrf(csrf -> csrf.disable())
        	.cors(Customizer.withDefaults())
        	.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
            		
            	.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers("/auth/login", "/auth/register").permitAll()

                // Hotel
                .requestMatchers(HttpMethod.GET, "/admin/hotels/location/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")                .requestMatchers(HttpMethod.GET, "/hotels/location/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.POST, "/admin/hotels").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.PUT, "/hotels").hasAuthority("ROLE_MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/hotels/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/hotels/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")
                //.requestMatchers(HttpMethod.GET, "/hotels").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")

                // Room
                .requestMatchers(HttpMethod.POST, "/rooms").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .requestMatchers(HttpMethod.PUT, "/rooms").hasAuthority("ROLE_MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/rooms/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/rooms/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")

                // Booking
                .requestMatchers(HttpMethod.POST, "/bookings").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER")
                .requestMatchers(HttpMethod.GET, "/bookings/all").hasAnyAuthority("ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/bookings/user/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/bookings/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.PUT, "/bookings").hasAnyAuthority("ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.PUT, "/bookings/cancel/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/bookings/**").hasAuthority("ROLE_ADMIN")

                // Review
                .requestMatchers(HttpMethod.POST, "/reviews").hasAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.PUT, "/reviews").hasAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.DELETE, "/reviews/**").hasAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.GET, "/reviews/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")

                // Payment
                .requestMatchers(HttpMethod.POST, "/payments").hasAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.GET, "/payments/history").hasAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.GET, "/payments/all").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET, "/payments/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers(HttpMethod.PUT, "/payments").hasAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.DELETE, "/payments/**").hasAuthority("ROLE_ADMIN")

                // Admin
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                
                // Manager
                .requestMatchers("/manager/**").hasAuthority("ROLE_MANAGER")

                .anyRequest().authenticated()

            )
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:4200"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        config.setAllowCredentials(true); 
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}