package ru.itis.afarvazov.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.itis.afarvazov.dto.news.ApiResponse;
import ru.itis.afarvazov.dto.news.NewsItem;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class NewsApiServiceImpl implements NewsApiService {

    public static void main(String[] args) {
        System.out.println(new NewsApiServiceImpl().getNews());
    }

    @Override
    public List<NewsItem> getNews() {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        String response = "";
        Request request = new Request.Builder().url("https://newsapi.org/v2/everything?q=games&apiKey=b625c00bac6640bba4048f9743e0ec02")
                .build();
        try {
            response = client.newCall(request).execute().body().string();
        } catch (IOException e) {
            throw new IllegalStateException();
        }
//        try {
//            System.out.println(mapper.readValue(response, ApiResponse.class).getStatus());
//        } catch (JsonProcessingException e) {
//            throw new IllegalArgumentException(e);
//        }
        return null;
    }
}
