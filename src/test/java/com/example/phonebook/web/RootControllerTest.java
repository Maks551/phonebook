package com.example.phonebook.web;

import org.junit.jupiter.api.Test;

import static com.example.phonebook.TestUtil.userAuth;
import static com.example.phonebook.UserTestData.USER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RootControllerTest extends AbstractControllerTest {

    @Test
    void testPhonebooks() throws Exception {
        mockMvc.perform(get("/phonebooks")
                .with(userAuth(USER)))
                .andDo(print())
                .andExpect(view().name("phonebooks"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/meals.jsp"));
    }

    @Test
    void testLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));
    }
}