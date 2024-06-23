package ru.kata.spring.boot_security.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    @GetMapping()
    public String adminsPage(@AuthenticationPrincipal User admin, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("admin", admin);
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("roleList", roleService.roleList());
        return "admin/admin_page";
    }

    @PutMapping()
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}