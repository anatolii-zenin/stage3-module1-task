package com.mjc.school.repository;

import com.mjc.school.repository.implementation.AuthorModel;
import com.mjc.school.repository.implementation.NewsModel;

import java.util.List;

public interface NewsRepository {
    Boolean deleteNewsEntry(Long id);
    NewsModel readByIdNews(Long id);
    Long createNewsEntry(NewsModel news);
    List<NewsModel> readAllNews();
    Boolean updateNewsEntry(NewsModel news);
    List<AuthorModel> getAllAuthors();
    void setDataSource();
    void setDataSource(String newsFile, String authorsFile);
    String getDateFormatPattern();
}
