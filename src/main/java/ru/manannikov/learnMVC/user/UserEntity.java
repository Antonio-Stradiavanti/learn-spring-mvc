package ru.manannikov.learnMVC.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    // Свойства
    @Id @GeneratedValue
    private Long id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    String roles;

    public UserEntity() {

    }

    public UserEntity(String userName, String password, String roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}
