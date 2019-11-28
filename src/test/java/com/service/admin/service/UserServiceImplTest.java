package com.service.admin.service;

import com.service.admin.model.User;
import com.service.admin.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    private User user;

    @Before
    public void init() {
        //Given
        user = new User();
        user.setFirstname("firstname");
        user.setLastname("lastname");
        user.setPassword("password");
    }

    @Test
    public void create() {
        when(userRepository.saveAndFlush(user)).thenReturn(user);

        //When
        User userToCreate = userService.create(user);

        //Then
        assertNotNull(userToCreate);
        assertEquals("firstname", userToCreate.getFirstname());
        assertEquals("lastname", userToCreate.getLastname());

        verify(userRepository, times(1)).saveAndFlush(user);

    }

    @Test
    public void update() {

        //Given
        User userToUpdate = new User();
        userToUpdate.setFirstname("firstname1");
        userToUpdate.setLastname("lastname1");

        when(userRepository.saveAndFlush(userToUpdate)).thenReturn(userToUpdate);

        //When
        User updatedUser = userService.update(userToUpdate);

        //Then
        assertNotNull(updatedUser);
        assertEquals("firstname1", updatedUser.getFirstname());
        assertEquals("lastname1", updatedUser.getLastname());

        verify(userRepository, times(1)).saveAndFlush(userToUpdate);
    }

    @Test
    public void delete() {
        //Given
        long id = 1;

        //When
        doNothing().when(userRepository).deleteById(id);
        boolean deletedUser = userService.delete(id);

        //Then
        assertTrue(deletedUser);
    }

    @Test
    public void findById() {


    }

    @Test
    public void fetchUsers() {
    }
}