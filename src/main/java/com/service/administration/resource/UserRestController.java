package com.service.administration.resource;
import com.service.administration.exception.UserNotFoundException;
import com.service.administration.model.User;
import com.service.administration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/users")
public class UserRestController{

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
    public ResponseEntity<Stream<User>> findAllUsers() {
        Stream<User> users = userService.fetchUsers();
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
    public ResponseEntity<Optional<User>> createUser(User user) {
        Optional<User> userToCreate = Optional.empty();
        if (user != null) {
            userToCreate = userService.create(user);
        }
        return new ResponseEntity<>(userToCreate, HttpStatus.OK);
    }
}
