package ro.ddavid8.springbootprojects.sendemail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ddavid8.springbootprojects.sendemail.models.CreateUserResponse;
import ro.ddavid8.springbootprojects.sendemail.models.User;
import ro.ddavid8.springbootprojects.sendemail.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sendEmail/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
