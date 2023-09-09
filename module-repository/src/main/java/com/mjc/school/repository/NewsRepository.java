package com.mjc.school.repository;

import com.mjc.school.repository.NewsEntity;

import java.util.List;

public interface NewsRepository {
    boolean deleteNewsEntry(int id);
    NewsEntity getNewsById(int id);
    int createNewsEntry(NewsEntity news);
    List<NewsEntity> getAllNews();
    boolean updateNewsEntry(NewsEntity news);
    List<AuthorEntity> getAllAuthors();
}
