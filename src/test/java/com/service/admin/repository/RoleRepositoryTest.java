package com.service.admin.repository;

import com.service.admin.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void should_create_role_test() {
        Role role = new Role();
        role.setAuthority("USER_ROLE");
        Role createdRole = entityManager.persist(role);

        assertNotNull(createdRole);
        assertEquals("USER_ROLE", role.getAuthority());
    }
}