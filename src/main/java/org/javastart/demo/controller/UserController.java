package org.javastart.demo.controller;

import org.javastart.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers() {
        return List.of(new User("Marcin", 25), new User("Rafał", 27));
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(name = "id") long id) {
        return new User("User with id 1", 324);
    }
}
