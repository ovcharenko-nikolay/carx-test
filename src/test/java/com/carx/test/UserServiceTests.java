package com.carx.test;

import com.carx.test.persistance.model.Activity;
import com.carx.test.persistance.model.User;
import com.carx.test.persistance.repo.ActivityRepo;
import com.carx.test.persistance.repo.UserRepo;
import com.carx.test.persistance.service.IUserService;
import com.carx.test.persistance.service.UserService;
import com.carx.test.persistance.service.exception.UserServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserService.class})
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private ActivityRepo activityRepo;

    @Test(expected = UserServiceException.class)
    public void testUserServiceSyncMethodNullValues() throws UserServiceException {
        userService.sync(null, null, null, null);
    }

    @Test
    public void testUserServiceSyncMethod() throws UserServiceException {
        UUID userUUID = UUID.randomUUID();
        Integer money = 500;
        String country = "RU";
        String json = "{\"test\":\"me\"}";
        Mockito.when(userRepo.findById(userUUID)).thenReturn(Optional.empty());
        Mockito.when(userRepo.save(Mockito.any(User.class))).thenReturn(null);
        userService.sync(userUUID, money, country, json);
        Mockito.verify(userRepo, Mockito.times(1)).findById(userUUID);
        Mockito.verify(userRepo, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test(expected = UserServiceException.class)
    public void testUserServiceCurrentStateMethodNullValues() throws UserServiceException {
        userService.currentState(null);
    }

    @Test
    public void testUserServiceCurrentStateMethod() throws UserServiceException {
        UUID userUUID = UUID.randomUUID();
        Mockito.when(userRepo.findById(userUUID)).thenReturn(Optional.empty());
        User user = userService.currentState(userUUID);
        Mockito.verify(userRepo, Mockito.times(1)).findById(userUUID);
        Assert.assertNull(user);
    }

    @Test
    public void testUserServiceSaveActivityMethodNullValues() throws UserServiceException {
        UUID userUUID = UUID.randomUUID();
        Integer activity = 100;
        Mockito.when(activityRepo.save(Mockito.any(Activity.class))).thenReturn(null);
        userService.saveActivity(userUUID, activity);
        Mockito.verify(activityRepo, Mockito.times(1)).save(Mockito.any(Activity.class));
    }

    @Test(expected = UserServiceException.class)
    public void testUserServiceSaveActivityMethod() throws UserServiceException {
        userService.saveActivity(null, null);
    }

}
