package com.mjc.school.repository;

import com.mjc.school.repository.implementation.AuthorEntity;
import com.mjc.school.repository.implementation.NewsEntity;

import java.util.List;

public interface NewsRepository {
    Boolean deleteNewsEntry(long id);
    NewsEntity readByIdNews(long id);
    long createNewsEntry(NewsEntity news);
    List<NewsEntity> readAllNews();
    Boolean updateNewsEntry(NewsEntity news);
    List<AuthorEntity> getAllAuthors();
    void setDataSource();
    void setDataSource(String newsFile, String authorsFile);
    String getDateFormatPattern();
}
