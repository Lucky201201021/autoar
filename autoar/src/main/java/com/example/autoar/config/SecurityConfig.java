package com.example.autoar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Отключаем для простоты API
                .cors(withDefaults())
                .authorizeHttpRequests(auth -> auth
                        // GET запросы (просмотр) доступны всем авторизованным (и EMPLOYER, и EMPLOYEE)
                        .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/tasks/*").authenticated()

                        // POST и DELETE (создание/удаление) - только EMPLOYER
                        .requestMatchers(org.springframework.http.HttpMethod.POST, "/api/tasks/*").hasRole("EMPLOYER")
                        .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/api/tasks/*").hasRole("EMPLOYER")

                        // PUT (взять задачу) - доступно EMPLOYEE
                        .requestMatchers(org.springframework.http.HttpMethod.PUT, "/api/tasks/*/take").hasRole("EMPLOYEE")

                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults()); // Используем базовую авторизацию (логин/пароль в заголовке)

        return http.build();
    }

    // Создаем тестовых пользователей в памяти
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails boss = User.withDefaultPasswordEncoder()
                .username("boss")
                .password("password")
                .roles("EMPLOYER")
                .build();

        UserDetails worker = User.withDefaultPasswordEncoder()
                .username("worker")
                .password("password")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(boss, worker);
    }
}