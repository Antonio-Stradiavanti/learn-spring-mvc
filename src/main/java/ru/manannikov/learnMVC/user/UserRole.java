package ru.manannikov.learnMVC.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRole implements GrantedAuthority {
    @Id @GeneratedValue
    private Long id;
    private String authority;

    @Override
    public String getAuthority() {
        return "";
    }
}
