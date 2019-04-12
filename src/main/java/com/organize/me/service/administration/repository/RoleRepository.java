package com.organize.me.service.administration.repository;

import com.organize.me.service.administration.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role,Long> {

}
