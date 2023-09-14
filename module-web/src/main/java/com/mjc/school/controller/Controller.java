package com.mjc.school.controller;

import com.mjc.school.dto.NewsDTO;

import java.util.List;

public interface Controller {
    boolean deleteNewsEntry(long id);
    NewsDTO getNewsById(long id);
    long createNewsEntry(NewsDTO newsDto);
    List<NewsDTO> getAllNews();
    boolean updateNewsEntry(NewsDTO news);
    void init();
}
