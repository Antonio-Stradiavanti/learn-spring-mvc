package ru.manannikov.learnMVC.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserManagementRepository extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> findByUserName(String userName);
}
