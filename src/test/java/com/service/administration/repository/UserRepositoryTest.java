package com.service.administration.repository;

import com.service.administration.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
//@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void should_create_user_and_persist_it_test(){
        //Given
        User user=new User();
        user.setFirstname("firstname");
        user.setLastname("lastname");

        System.out.println("Launch persistence");
        //When
        User createUser=entityManager.persist(user);

        System.out.println("Terminate persistence");

        //Then
        assertNotNull(createUser);
        assertEquals("firstname",createUser.getFirstname());

    }
}