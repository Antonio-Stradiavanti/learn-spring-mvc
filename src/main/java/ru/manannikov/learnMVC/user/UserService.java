package ru.manannikov.learnMVC.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import ru.manannikov.learnMVC.exception.ResourceNotFoundExcetion;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserManagementRepository repository;

    public UserDetails findUserByName(String username) {
        UserAccountEntity user = repository.findByUserName(username);
        
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return User.builder().username(user.getUserName()).password(encoder.encode(user.getPassword())).authorities(user.getAuthorities()).build();
    }
    
    public List<UserAccountEntity> findAll() {
        return repository.findAll();
    }

    public UserAccountEntity create(UserAccountEntity userAccount) {
        return repository.save(userAccount);
    }

    public void delete(Long id) {
        UserAccountEntity userAccount = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcetion("Пользователь с идентификатором id = \" + id + \" не найден.\""));
        repository.delete(userAccount);
    }
}
