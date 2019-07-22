package com.carx.test.rest;

import com.carx.test.persistance.service.IUserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/{uuid}/syc", method = RequestMethod.POST)
    public void syncUserData(@PathVariable(name = "uuid") UUID uuid, @RequestBody JsonNode json) {
        // TODO implement
    }

    @RequestMapping(path = "/{uuid}/currentData", method = RequestMethod.GET)
    public JsonNode currentUserData(@PathVariable(name = "uuid") UUID uuid) {
        // TODO implement
        return null;
    }

    @RequestMapping(path = "/{uuid}/currentData", method = RequestMethod.POST)
    public void saveUserActivity(@PathVariable(name = "uuid") UUID uuid, @RequestBody Integer activity) {
        // TODO implement
    }

}
