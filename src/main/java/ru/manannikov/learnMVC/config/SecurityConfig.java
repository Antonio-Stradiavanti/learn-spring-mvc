package ru.manannikov.learnMVC.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.manannikov.learnMVC.user.UserService;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    private final UserService service;
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    // Определим права доступа.
    // build возвращает реализацию интерфейса SecurityFilterChain
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Определяет то, как именно мы будем авторизировать (разрешать доступ к методам API)
        // httpBasic -- не создает html форму и используется для аунтификации через терминал, т.е. подходит для тестирования API через Postman, в браузере выдает стандартное всплывающее окно.
        String path = "/api/**";
        http.authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests.requestMatchers(HttpMethod.GET, path)
                        .authenticated().requestMatchers(HttpMethod.PUT, path).hasRole("ADMIN").requestMatchers(HttpMethod.DELETE, path).hasRole("ADMIN").requestMatchers(HttpMethod.POST, path).hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().denyAll()
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // Этот бин создает реализацию функционального интерфейса, которая будет использована в контексте, где ему будет передан username % usd.loadUserByUsername(username).
    @Bean
    UserDetailsService userDetailsService() {
        return service::findUserByName;
    }
}
