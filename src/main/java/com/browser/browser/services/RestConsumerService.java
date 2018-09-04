package com.browser.browser.services;

import com.browser.browser.models.AlteredNews;
import com.browser.browser.models.News;
import com.browser.browser.models.News;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestConsumerService {
    private static final String API_KEY = "765305ec63694acc89bb7ffa5cefedf7";

    public AlteredNews consume(String country, String category) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=" +
                country + "&category=" + category + "&apiKey=" + API_KEY, News.class);
        return new
                AlteredNews.AlteredNewsBuilder(country, category)
                           .setArticles(news.getArticles())
                           .build();
    }
}
