package ru.manannikov.learnMVC.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.manannikov.learnMVC.user.UserService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserService service;

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
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/v3/api-docs", "/v3/api-docs.yaml", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources", "/swagger-resources/**", "/swagger-ui.html", "/auth/**").permitAll();
                auth.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
                auth.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
                auth.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");
                auth.anyRequest().authenticated();
            })
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return service;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

}
