package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void add(User user);

    User get(long id);

    User findByUsername(String username);

    void update(User user);

    void delete(long id);
}
