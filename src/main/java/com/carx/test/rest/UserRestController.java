package com.carx.test.rest;

import com.carx.test.persistance.model.User;
import com.carx.test.persistance.service.IUserService;
import com.carx.test.persistance.service.exception.UserServiceException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserRestController {

    private static final Logger log = LogManager.getLogger(UserRestController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/{uuid}", method = RequestMethod.POST)
    public ResponseEntity syncUserData(@PathVariable(name = "uuid") UUID uuid, @RequestBody JsonNode json) {
        try {
            Integer money = json.get("money").intValue();
            String country = json.get("country").textValue();
            userService.sync(uuid, money, country, json.toString());
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity currentUserData(@PathVariable(name = "uuid") UUID uuid) {
        try {
            User user = userService.currentState(uuid);
            if (Objects.nonNull(user)) {
                ObjectMapper objectMapper = new ObjectMapper();
                return ResponseEntity.ok(objectMapper.readTree(user.getJson()));
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (UserServiceException e) {
            log.error("failed to get data from DB");
            log.error(e.getStackTrace());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            log.error("failed to read user data");
            log.error(e.getStackTrace());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{uuid}/activity", method = RequestMethod.POST)
    public ResponseEntity saveUserActivity(@PathVariable(name = "uuid") UUID uuid, @RequestBody Integer activity) {
        try {
            userService.saveActivity(uuid, activity);
            return new ResponseEntity(HttpStatus.OK);
        } catch (UserServiceException e) {
            log.error(e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
