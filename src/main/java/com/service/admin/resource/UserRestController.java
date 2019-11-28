package com.service.admin.resource;

import com.service.admin.exception.UserNotFoundException;
import com.service.admin.model.User;
import com.service.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/byUsername/{username}")
    public ResponseEntity<User> findUserByUsername(String username) {
        Optional<User> userByUsername = Optional.empty();
        if (!StringUtils.isEmpty(username)) {
            userByUsername = userService.findUserByUsername(username);
            if (!userByUsername.isPresent()) {
                throw new UserNotFoundException("User " + username + " not find");
            }
        }
        return new ResponseEntity<>(userByUsername.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findUsers() {
        List<User> users = userService.fetchUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/byId/{id}")
    public ResponseEntity<Optional<User>> findUserById(Long id) {
        Optional<User> userToFind = Optional.empty();
        if (id != null) {
            userToFind = userService.findById(id);
            if (!userToFind.isPresent()) {
                throw new UserNotFoundException("User " + id + " not find");
            }
        }
        return new ResponseEntity<>(userToFind, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User userToCreate = null;
        if (user != null) {
            userToCreate = userService.create(user);
        }
        return new ResponseEntity<>(userToCreate, HttpStatus.OK);
    }

    @PutMapping("/update/profile")
    public ResponseEntity<User> UpdateUser(@RequestBody User user) {
        User updatedUser = null;
        if (user != null) {
            updatedUser = userService.update(user);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
