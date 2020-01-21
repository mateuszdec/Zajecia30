package org.javastart.demo.controller;

import org.javastart.demo.model.User;
import org.javastart.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
//        return userRepository.findAll();
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
//    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<User> getUser(@PathVariable(name = "id") long id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.created(URI.create("/users/" + savedUser.getId())).build();
    }
}
