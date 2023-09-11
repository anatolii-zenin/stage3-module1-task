package com.mjc.school.repository;

import com.mjc.school.repository.NewsEntity;

import java.util.List;

public interface NewsRepository {
    boolean deleteNewsEntry(long id);
    NewsEntity getNewsById(long id);
    int createNewsEntry(NewsEntity news);
    List<NewsEntity> getAllNews();
    boolean updateNewsEntry(NewsEntity news);
    List<AuthorEntity> getAllAuthors();
    public void readDataFromFiles();
    public void readDataFromFiles(String newsFile, String authorsFile);
}
