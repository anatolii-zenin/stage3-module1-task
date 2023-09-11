package com.mjc.school.service;



import java.util.List;

public interface NewsService {
    boolean deleteNewsEntry(long id);
    NewsDTO getNewsById(long id);
    int createNewsEntry(NewsDTO news);
    List<NewsDTO> getAllNews();
    boolean updateNewsEntry(NewsDTO news);
}
