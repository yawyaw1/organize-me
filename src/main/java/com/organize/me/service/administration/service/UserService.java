package com.organize.me.service.administration.service;

import com.organize.me.service.administration.model.User;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {

    /**
     * @param user
     * @return
     */
    Optional<User> create(User user);

    /**
     * @param user
     * @return
     */
    Optional<User> update(User user);

    /**
     * @param id
     */
    boolean delete(Long id);

    /**
     * @param id
     * @return
     */
    Optional<User> findById(Long id);

    /**
     * @return
     */
    Stream<User> fetchUsers();


}
