package com.mjc.school.repository;

import com.mjc.school.repository.NewsEntity;

import java.util.List;

public class CNewsRepository implements NewsRepository {
    @Override
    public boolean deleteNewsEntry(int id) {
        return false;
    }

    @Override
    public NewsEntity getNewsById(int id) {
        return null;
    }

    @Override
    public int createNewsEntry(NewsEntity news) {
        return 0;
    }

    @Override
    public List<NewsEntity> getAllNews() {
        return null;
    }

    @Override
    public boolean updateNewsEntry(NewsEntity news) {
        return false;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return null;
    }

    private int AddAuthor(String authorName) {
        return 0;
    }
}
