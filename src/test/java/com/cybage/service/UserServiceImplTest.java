package com.cybage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.cybage.dao.UserDao;
import com.cybage.model.User;
import com.cybage.onlinefoodapp.OnlineFoodAppApplication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


//@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = OnlineFoodAppApplication.class
   // webEnvironment = WebEnvironment.RANDOM_PORT
)
public class UserServiceImplTest {

    @MockBean
    UserDao repository;
    
    
    @Test
    void testFindByUserEmail() {
        User user=new User();
        user.setUserEmail("manish@gmail.com");
        user.setUserId(10);

        Mockito.doReturn(user).when(repository).findByUserEmail("manish@gmail.com");

        assertEquals(10, repository.findByUserEmail("manish@gmail.com").getUserId());

    }
    
    
    @Test
    void testFindByUserEmailAndUserPassword() {
        User user=new User();
        user.setUserEmail("manish@gmail.com");
        user.setUserPassword("man@123");
        user.setAttemptsCount(1);

        Mockito.doReturn(user).when(repository).findByUserEmailAndUserPassword("manish@gmail.com", "man@123");

        assertEquals(1, repository.findByUserEmailAndUserPassword("manish@gmail.com", "man@123").getAttemptsCount());
    }

    
    @Test
    void testSaveUser() {
        User user=new User();
        user.setUserPassword("333");

        Mockito.doReturn(user).when(repository).save(user);

        assertEquals("333", repository.save(user).getUserPassword());
    }

}