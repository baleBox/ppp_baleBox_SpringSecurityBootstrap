package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.Optional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository <Role,Long> {

}
