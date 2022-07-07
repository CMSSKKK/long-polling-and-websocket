package com.example.longpollingandwebsocket.longpolling;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@SpringBootTest
@AutoConfigureMockMvc
class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void longPollingTest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/coffee?coffeeName=americano"))
                .andExpect(request().asyncStarted())
                .andReturn();

        String response = mockMvc
                .perform(asyncDispatch(mvcResult))
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(response).isEqualTo("Americano가 완성되었습니다. 가격은 4500입니다.");

    }
}
