package ru.manannikov.learnMVC.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.util.List;
import java.util.Optional;

// Извлекает пользователя из бд при авторизации
@Service
@AllArgsConstructor
// Реализует UserDetailService
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    // Возвращает пользователя по имени пользователя
    @Override
    // UserDetails -> интерфейс, содержит методы, предоставляющие основную информацию о пользователе, User -> его реализация
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserEntity userEntity = repository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Пользователь " + username + "-> не найден."));

        return User.builder()
                .username(userEntity.getUserName())
                .password(userEntity.getPassword())
                .roles(getRoles(userEntity))
                .build();
    }

    private String[] getRoles(UserEntity userEntity) {
        if (userEntity.getRole() == null) {
            return new String[]{"USER"};
        }
        return userEntity.getRole().split(", *");
    }

}
