package ru.itis.afarvazov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class NewsController {

    public String getNews(Model model) {
        return "news_page";
    }

}
