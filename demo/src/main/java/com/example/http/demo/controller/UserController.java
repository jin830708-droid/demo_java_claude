package com.example.http.demo.controller;

import com.example.http.demo.model.User;
import com.example.http.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
