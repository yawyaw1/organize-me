package com.service.admin.service;

import com.service.admin.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {

    /**
     * @param user
     * @return
     */
    User create(User user);

    /**
     * @param user
     * @return
     */
    User update(User user);

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
    List<User> fetchUsers();

    /**
     *
     * @param username
     * @return
     */
    Optional<User> findUserByUsername(String username);
}
