package com.organize.me.service.administration.repository;

import com.organize.me.service.administration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
