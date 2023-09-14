package com.mjc.school.repository;

import com.mjc.school.repository.models.AuthorModel;
import com.mjc.school.repository.models.NewsModel;

import java.util.List;

public interface NewsRepository {
    Boolean deleteNewsEntry(Long id);
    NewsModel readByIdNews(Long id);
    NewsModel createNewsEntry(NewsModel news);
    List<NewsModel> readAllNews();
    NewsModel updateNewsEntry(NewsModel news);
    List<AuthorModel> getAllAuthors();
    String getDateFormatPattern();
}
