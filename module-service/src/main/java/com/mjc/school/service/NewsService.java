package com.mjc.school.service;



import com.mjc.school.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    boolean deleteNewsEntry(long id);
    NewsDTO getNewsById(long id);
    long createNewsEntry(NewsDTO news);
    List<NewsDTO> getAllNews();
    boolean updateNewsEntry(NewsDTO news);
    void init();
}
