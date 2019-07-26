package com.carx.test;

import com.carx.test.persistance.service.UserService;
import com.carx.test.rest.UserRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {UserRestController.class})
public class UserRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void testUserPost() throws Exception {
        UUID userUUID = UUID.randomUUID();
        String json = "{\"user\":\"vasia\",\"country\":\"RU\",\"money\":800,\"level\":10,\"vip\":true}";
        Mockito.doNothing().when(userService).sync(userUUID, 800, "RU", json);
        mvc.perform(MockMvcRequestBuilders
                .post("/user/" + userUUID.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(userService, Mockito.times(1)).sync(userUUID, 800, "RU", json);

    }

}
