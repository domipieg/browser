package com.browser.browser;

import com.browser.browser.models.AlteredNews;
import com.browser.browser.services.RestConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RestConsumerServiceTest {

    @Autowired
    private RestConsumerService restConsumerService;

    @Test
    public void shouldReturnNotNullObject() {
        AlteredNews alteredNews = restConsumerService.consume("pl", "technology");
        assertNotNull(alteredNews);
    }
}
