package com.mjc.school.service;



import java.util.List;

public interface NewsService {
    boolean deleteNewsEntry(int id);
    NewsDTO getNewsById(int id);
    int createNewsEntry(NewsDTO news);
    List<NewsDTO> getAllNews();
    boolean updateNewsEntry(NewsDTO news);
}
