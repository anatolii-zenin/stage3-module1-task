package com.mjc.school.service;



import com.mjc.school.repository.NewsRepository;

import java.util.List;

public interface NewsService {
    boolean deleteNewsEntry(long id);
    NewsDTO getNewsById(long id);
    int createNewsEntry(NewsDTO news);
    List<NewsDTO> getAllNews();
    boolean updateNewsEntry(NewsDTO news);
    void init();
}
