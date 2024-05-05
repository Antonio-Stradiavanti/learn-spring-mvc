package ru.manannikov.learnMVC.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<UserAccountEntity, Long>
{
    UserAccountEntity findByUserName(String userName);
}
