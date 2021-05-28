package ru.itis.afarvazov.services;

import ru.itis.afarvazov.dto.news.NewsItem;

import java.util.List;

public interface NewsApiService {
    List<NewsItem> getNews();
}
