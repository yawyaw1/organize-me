package com.service.admin.service;

import com.service.admin.model.Role;
import com.service.admin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean create(Role role) {
        if (role != null) {
            roleRepository.save(role);
            return true;
        }
        return false;
    }
}
