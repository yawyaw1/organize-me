package com.organize.me.service.administration.resource;


import com.organize.me.service.administration.model.User;
import com.organize.me.service.administration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/byUsername/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable("username") String username) {
        Optional<User> userByUsername = Optional.empty();
        if (!StringUtils.isEmpty(username)) {
            userByUsername = userService.findUserByUsername(username);
        }
        return new ResponseEntity<>(userByUsername.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Stream<User>> findAllUsers() {
        Stream<User> users = userService.fetchUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/byId/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Long id) {
        Optional<User> userToFind = Optional.empty();
        if (id != null) {
            userToFind = userService.findById(id);
        }
        return new ResponseEntity<>(userToFind, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Optional<User>> createUser(@RequestBody User user) {
        Optional<User> userToCreate = Optional.empty();
        if (user != null) {
            userToCreate = userService.create(user);
        }
        return new ResponseEntity<>(userToCreate, HttpStatus.OK);
    }

}
