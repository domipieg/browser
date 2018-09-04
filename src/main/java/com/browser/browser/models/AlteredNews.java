package com.browser.browser.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AlteredNews {
    private final String country;
    private final String category;
    private final ArrayList<AlteredArticle> articles;

    private AlteredNews(AlteredNewsBuilder builder) {
        this.country = builder.country;
        this.category = builder.category;
        this.articles = builder.articles;
    }

    public String getCountry() {
        return country;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<AlteredArticle> getArticles() {
        return articles;
    }

    @Override
    public String toString() {
        return "AlteredNews{" +
                "country='" + country + '\'' +
                ", category='" + category + '\'' +
                ", articles=" + articles +
                '}';
    }

    public static class AlteredNewsBuilder {
        private final String country;
        private final String category;
        private ArrayList<AlteredArticle> articles;

        public AlteredNewsBuilder(String country, String category) {
            this.country = country;
            this.category = category;
        }

        public AlteredNewsBuilder setArticles(ArrayList<Article> articles) {
            this.articles = new ArrayList<AlteredArticle>();
            for (Article each : articles) {
                AlteredArticle alteredArticle = new AlteredArticle();
                alteredArticle.setAuthor(each.getAuthor());
                alteredArticle.setTitle(each.getTitle());
                alteredArticle.setDescription(each.getDescription());
                alteredArticle.setDate(parseDate(each.getPublishedAt()));
                alteredArticle.setSourceName(each.getSource().getName());
                alteredArticle.setArticleUrl(each.getUrl());
                alteredArticle.setImageUrl(each.getUrlToImage());
                this.articles.add(alteredArticle);
            }
            return this;
        }

        private String parseDate(String date) {
            SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
            Date d = null;
            try {
                d = input.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
            String formattedTime = output.format(d);
            return formattedTime;
        }

        public AlteredNews build() {
            return new AlteredNews(this);
        }

    }
}
