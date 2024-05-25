package ru.manannikov.learnMVC.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserEntity {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    // Мы хотим получить полномочия пользователя как только получим информацию о пользователе.
    private String role;

    public UserEntity(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
