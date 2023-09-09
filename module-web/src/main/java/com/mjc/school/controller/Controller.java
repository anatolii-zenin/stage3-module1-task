package com.mjc.school.controller;

import com.mjc.school.service.NewsDTO;

import java.util.List;

public interface Controller {
    boolean deleteNewsEntry(int id);
    NewsDTO getNewsById(int id);
    int createNewsEntry(NewsDTO news);
    List<NewsDTO> getAllNews();
    boolean updateNewsEntry(NewsDTO news);
}
