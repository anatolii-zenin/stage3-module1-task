package com.mjc.school.repository;

import java.util.List;

public interface NewsRepository {
    boolean deleteNewsEntry(long id);
    NewsEntity getNewsById(long id);
    long createNewsEntry(NewsEntity news);
    List<NewsEntity> getAllNews();
    boolean updateNewsEntry(NewsEntity news);
    List<AuthorEntity> getAllAuthors();
    void readDataFromFiles();
    void readDataFromFiles(String newsFile, String authorsFile);
    String getDateFormatPattern();
}
