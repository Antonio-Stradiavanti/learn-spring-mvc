package ru.manannikov.learnMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.manannikov.learnMVC.user.UserService;

@Configuration
public class SecurityConfig {
    private final UserService service;

    public SecurityConfig(UserService service) {
        this.service = service;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Определим права доступа.
    // build возвращает реализацию интерфейса SecurityFilterChain
    // Этот бин создает реализацию функционального интерфейса, которая будет использована в контексте, где ему будет передан username % usd.loadUserByUsername(username).
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Определяет то, как именно мы будем авторизировать (разрешать доступ к методам API)
        // httpBasic -- не создает html форму и используется для аунтификации через терминал, т.е. подходит для тестирования API через Postman, в браузере выдает стандартное всплывающее окно.
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                // Первый путь -- документация
//                    .requestMatchers("/v3/api-docs", "/v3/api-docs.yaml",  "/v3/api-docs/**", "/swagger-ui/**",  "/swagger-resources", "/swagger-resources/**",  "/swagger-ui.html").permitAll()
//
//                    .requestMatchers("/api/**").hasRole("USER")
//
//                    .requestMatchers("/admin/**").hasRole("ADMIN")
//                  .anyRequest().denyAll()
                    .anyRequest().permitAll()
            )
//            .userDetailsService(service)
//            .httpBasic(withDefaults())
            .build();
    }
}
