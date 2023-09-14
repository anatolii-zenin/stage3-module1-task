package com.mjc.school.service;

import com.mjc.school.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    Boolean deleteNewsEntry(Long id);
    NewsDTO getNewsById(Long id);
    Long createNewsEntry(NewsDTO news);
    List<NewsDTO> getAllNews();
    Boolean updateNewsEntry(NewsDTO news);
    void init();
}
