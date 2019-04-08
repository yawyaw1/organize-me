package com.organize.me.organizeme.service;

import com.organize.me.organizeme.model.User;
import com.organize.me.organizeme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> create(User user) {
        if(user != null ){
            return Optional.of(userRepository.saveAndFlush(user));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User user) {
        if(user != null ){
            return Optional.of(userRepository.saveAndFlush(user));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        if(id != null){
            userRepository.findById(id);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        if(id != null){
            return userRepository.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public Stream<User> fetchUsers() {
        return null;
    }
}
