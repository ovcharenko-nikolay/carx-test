package com.carx.test.persistance.service;


import com.carx.test.persistance.model.Activity;
import com.carx.test.persistance.model.User;
import com.carx.test.persistance.repo.ActivityRepo;
import com.carx.test.persistance.repo.UserRepo;
import com.carx.test.persistance.service.exception.UserServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private static final Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public void sync(UUID userUUID, Integer money, String country, String json) throws UserServiceException {
        try {
            if (Objects.nonNull(userUUID) && Objects.nonNull(money) && Objects.nonNull(country) && Objects.nonNull(json)) {
                Optional<User> userOptional = userRepo.findById(userUUID);
                User user = null;
                ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
                if (userOptional.isPresent()) {
                    user = userOptional.get();
                } else {
                    user = new User();
                    user.setUuid(userUUID);
                    user.setCreateDate(now);
                }
                user.setMoney(money);
                user.setCountry(country);
                user.setJson(json);
                user.setUpdateDate(now);
                userRepo.save(user);
            } else {
                throw new UserServiceException("userUUID, money, country, json must not be null!");
            }
        } catch (Exception e) {
            log.error("failed to sync user data, userUUID {}. money {}, country {}, json {}", userUUID, money, country, json);
            log.error(e);
            throw new UserServiceException("failed to sync user data. Reason: " + e.getMessage());
        }
    }

    @Override
    public User currentState(UUID userUUID) throws UserServiceException {
        try {
            if (Objects.nonNull(userUUID)) {
                Optional<User> user = userRepo.findById(userUUID);
                return user.orElse(null);
            } else {
                throw new UserServiceException("User uuid is required");
            }
        } catch (Exception e) {
            log.error("failed to get user current data, userUUID {}", userUUID);
            log.error(e);
            throw new UserServiceException("failed to get user data. Reason: " + e.getMessage());
        }
    }

    @Override
    public void saveActivity(UUID userUUID, Integer activity) throws UserServiceException {
        if (Objects.nonNull(userUUID) && Objects.nonNull(activity)) {
            try {
                Activity activityEntity = new Activity();
                activityEntity.setUuid(UUID.randomUUID());
                activityEntity.setUserUUID(userUUID);
                activityEntity.setActivity(activity);
                activityEntity.setCreateDate(ZonedDateTime.now(ZoneId.of("UTC")));

                activityRepo.save(activityEntity);
            } catch (Exception e) {
                log.error("failed to save user activity. userUUID {}, activity {}", userUUID.toString(), activity.toString());
                log.error(e);
                throw new UserServiceException("failed save user activity. Reason: " + e.getMessage());
            }
        } else {
            throw new UserServiceException("userUUID and activity must not be null!");
        }
    }
}
