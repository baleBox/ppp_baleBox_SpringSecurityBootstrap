package ru.kata.spring.boot_security.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public List<Role> roleList() {
        return roleRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
    }

    @Override
    public Role getRole(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Role with id %s not found", id));
        }
        return role.get();
    }
}
