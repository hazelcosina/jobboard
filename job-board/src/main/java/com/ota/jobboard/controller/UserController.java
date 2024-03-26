package com.ota.jobboard.controller;

import com.ota.jobboard.entity.User;
import com.ota.jobboard.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        List<User> positions = userService.getAll();
        return ResponseEntity.ok(positions);
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
    }
}
