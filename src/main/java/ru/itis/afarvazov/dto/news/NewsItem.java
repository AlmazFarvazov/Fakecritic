package ru.itis.afarvazov.dto.news;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsItem {
    private NewsItemSource source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
}
