package org.javastart.demo.controller;

import org.javastart.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        return List.of(new User("Marcin", 25), new User("Rafał", 27));
    }
}
