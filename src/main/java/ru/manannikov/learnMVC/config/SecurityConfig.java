package ru.manannikov.learnMVC.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Определим права доступа.
    // build возвращает реализацию интерфейса SecurityFilterChain
    // Этот бин создает реализацию функционального интерфейса, которая будет использована в контексте, где ему будет передан username % usd.loadUserByUsername(username).
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Определяет то, как именно мы будем авторизировать (разрешать доступ к методам API)
        // httpBasic -- не создает html форму и используется для аунтификации через терминал, т.е. подходит для тестирования API через Postman, в браузере выдает стандартное всплывающее окно.
        String path = "/api/**";
        http.authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                        // Первый путь -- документация
                        .requestMatchers("/v3/api-docs", "/v3/api-docs.yaml",  "/v3/api-docs/**", "/swagger-ui/**",  "/swagger-resources", "/swagger-resources/**",  "/swagger-ui.html").permitAll()

                        .requestMatchers(path).authenticated()

                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .anyRequest().denyAll()
        )
        .userDetailsService(service)
        .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
