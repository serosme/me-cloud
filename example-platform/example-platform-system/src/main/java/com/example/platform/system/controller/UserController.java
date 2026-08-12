package com.example.platform.system.controller;

import com.example.platform.system.entity.User;
import com.example.platform.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public User query(@RequestParam Long id) {
        return userService.queryById(id);
    }
}
