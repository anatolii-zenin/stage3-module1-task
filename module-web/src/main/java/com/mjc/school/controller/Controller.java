package com.mjc.school.controller;

import com.mjc.school.dto.NewsDTO;

import java.util.List;

public interface Controller {
    Boolean deleteNewsEntry(Long id);
    NewsDTO getNewsById(Long id);
    NewsDTO createNewsEntry(NewsDTO newsDto);
    List<NewsDTO> getAllNews();
    NewsDTO updateNewsEntry(NewsDTO news);
}
