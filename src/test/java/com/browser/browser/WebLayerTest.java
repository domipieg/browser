package com.browser.browser;

import com.browser.browser.controllers.NewsController;
import com.browser.browser.services.RestConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(NewsController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestConsumerService restConsumerService;

    @Test
    public void shouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/news/pl/technology"))
                .andExpect(status().isOk());
    }
}
