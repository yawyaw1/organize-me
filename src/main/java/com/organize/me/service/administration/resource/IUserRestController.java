package com.organize.me.service.administration.resource;


import com.organize.me.service.administration.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Stream;


public interface IUserRestController {

    ResponseEntity<User> findUserByUsername(@PathVariable("username") String username);

    ResponseEntity<Stream<User>> findAllUsers();

    ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Long id);

    ResponseEntity<Optional<User>> createUser(@RequestBody User user);
}
