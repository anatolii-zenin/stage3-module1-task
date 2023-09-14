package com.mjc.school.service;

import com.mjc.school.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    Boolean deleteNewsEntry(Long id);
    NewsDTO getNewsById(Long id);
    NewsDTO createNewsEntry(NewsDTO news);
    List<NewsDTO> getAllNews();
    NewsDTO updateNewsEntry(NewsDTO news);
    void init();
}
