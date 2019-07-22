package com.carx.test.persistance.service;


import com.carx.test.persistance.model.User;
import com.carx.test.persistance.repo.ActivityRepo;
import com.carx.test.persistance.repo.UserRepo;
import com.carx.test.persistance.service.exception.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public void sync(User user) throws UserServiceException {
        throw new UserServiceException("Not implemented!");
    }

    @Override
    public User currentState(UUID userUUID) throws UserServiceException {
        throw new UserServiceException("Not implemented!");
    }

    @Override
    public void saveActivity(UUID userUUID, Integer activity) throws UserServiceException {
        throw new UserServiceException("Not implemented!");
    }
}
