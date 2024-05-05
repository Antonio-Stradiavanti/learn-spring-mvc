package ru.manannikov.learnMVC.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserAccountEntity {
    // Свойства
    @Id @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<GrantedAuthority> authorities = new HashSet<>();

    // Конструктор
    public UserAccountEntity(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        authorities.add(new SimpleGrantedAuthority(role));
    }

}
