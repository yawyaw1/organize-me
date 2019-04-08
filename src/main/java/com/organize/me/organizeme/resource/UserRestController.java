package com.organize.me.organizeme.resource;


import com.organize.me.organizeme.model.User;
import com.organize.me.organizeme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/param/{id}", params = "version=1", headers = "X-API-VERSION=1")
    public ResponseEntity<User> getUserByIdV1(@PathVariable Long id) {
        User user = userService.findById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/param/{id}", params = "version=2", headers = "X-API-VERSION=2")
    public ResponseEntity<User> getUserByIdV2(@PathVariable Long id) {
        User user = userService.findById(id).get();
        user.setPassword("pass");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
