package com.carx.test.persistance.service;

import com.carx.test.persistance.model.User;
import com.carx.test.persistance.service.exception.UserServiceException;

import java.util.UUID;

public interface IUserService {

    void sync(UUID userUUID, Integer money, String country, String json) throws UserServiceException;

    User currentState(UUID userUUID) throws UserServiceException;

    void saveActivity(UUID userUUID, Integer activity) throws  UserServiceException;

}
