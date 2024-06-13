package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.MyUser;


import java.util.Optional;

@Repository
@Transactional
public interface MyUserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByFistName(String email);
}
