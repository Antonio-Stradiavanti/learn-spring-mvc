package ru.manannikov.learnMVC.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsEntity implements UserDetails {

    @Id @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    // Мы хотим получить полномочия пользователя как только получим информацию о пользователе.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_junction",
            // Используется с случае составного первичного ключа.
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<UserRole> authorities = new HashSet<>();

    @Override
    public String getUsername() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    };

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(Set<UserRole> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // Имя пользователя и пароль -> действительны, т.е. еще в силе.
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
