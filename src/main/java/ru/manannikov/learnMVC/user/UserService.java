package ru.manannikov.learnMVC.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserManagementRepository repository;

    public UserService(UserManagementRepository repository) {
        this.repository = repository;
    }
    // Возвращает пользователя по имени пользователя
    @Override
    // UserDetails -> интерфейс, содержит методы, предоставляющие основную информацию о пользователе, User -> его реализация
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUserName(username).map(UserSecurity::new).orElseThrow(() -> new UsernameNotFoundException("Пользователь с именем " + username + " -> не найден."));
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public UserEntity create(UserEntity userAccount) {
        return repository.save(userAccount);
    }

    public void delete(Long id) {
        UserEntity userAccount = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Пользователь с идентификатором id = \" + id + \" не найден.\""));
        repository.delete(userAccount);
    }
}
