package com.mjc.school.service;

import com.mjc.school.repository.NewsEntity;
import com.mjc.school.repository.AuthorEntity;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.CNewsRepository;

import java.util.List;

public class CNewsService implements NewsService {
    @Override
    public boolean deleteNewsEntry(int id) {
        return false;
    }

    @Override
    public NewsDTO getNewsById(int id) {
        return null;
    }

    @Override
    public int createNewsEntry(NewsDTO news) {
        return 0;
    }

    @Override
    public List<NewsDTO> getAllNews() {
        return null;
    }

    @Override
    public boolean updateNewsEntry(NewsDTO news) {
        return false;
    }

    private NewsEntity dtoToEntity(NewsDTO newsDto) {
        return null;
    }

    private AuthorEntity dtoToEntity(AuthorDTO authorDTO) {
        return null;
    }

    private NewsDTO entityToDto(NewsEntity newsEntity) {
        return null;
    }

    private AuthorDTO entityToDto(AuthorEntity authorEntity) {
        return null;
    }

    private List<AuthorEntity> getAllAuthors() {
        return null;
    }

    private int addAuthor(String name) {
        return 0;
    }
}
