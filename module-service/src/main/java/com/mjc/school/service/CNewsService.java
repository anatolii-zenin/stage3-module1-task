package com.mjc.school.service;

import com.mjc.school.repository.NewsEntity;
import com.mjc.school.repository.AuthorEntity;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.CNewsRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CNewsService implements NewsService {
    private static volatile CNewsService instance = new CNewsService();
    private NewsRepository newsRepo;
    private List<AuthorDTO> authors = new ArrayList<>();
    private List<NewsDTO> news = new ArrayList<>();
    @Override
    public boolean deleteNewsEntry(long id) {
        newsRepo.deleteNewsEntry(id);
        return true;
    }

    @Override
    public NewsDTO getNewsById(long id) {
        return null;
    }

    @Override
    public int createNewsEntry(NewsDTO news) {
        return 0;
    }

    @Override
    public List<NewsDTO> getAllNews() {
        return news;
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
        var builder = NewsDTO.getBuilder();
        builder.setId(newsEntity.getId())
                .setTitle(newsEntity.getTitle())
                .setContent(newsEntity.getContent())
                .setCreateDate(formatDate(newsEntity.getCreateDate()))
                .setLastUpdateDate(formatDate(newsEntity.getLastUpdateDate()))
                .setAuthor(getAuthorNameByID(newsEntity.getAuthorId()));
        return builder.build();
    }

    private AuthorDTO entityToDto(AuthorEntity authorEntity) {
        var builder = AuthorDTO.getBuilder();
        builder.setId(authorEntity.getId())
                .setName(authorEntity.getName());
        return builder.build();
    }

    private String getAuthorNameByID(long id) {
        var authorsWithId = authors.stream().filter(a -> a.getId() == id).collect(Collectors.toList());
        if (authorsWithId.size() > 1)
            throw new RuntimeException("found more than a single author with id:" + id);
        return authorsWithId.get(0).getName();
    }

    private String formatDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(newsRepo.getDateFormatPattern()));
    }

    private int addAuthor(String name) {
        return 0;
    }

    private void fetchNewsAndAuthors() {
        var authorEntities = newsRepo.getAllAuthors();
        var newsEntities = newsRepo.getAllNews();

        int authorCounter = 0;
        for (var authorEntity : authorEntities) {
            authors.add(entityToDto(authorEntity));
            authorCounter++;
        }

        int newsCounter = 0;
        for (var newsEntity : newsEntities) {
            news.add(entityToDto(newsEntity));
            newsCounter++;
        }

        System.out.println("fetched authors: " + authorCounter);
        System.out.println("fetched news: " + newsCounter);
    }

    public void setNewsRepo(NewsRepository newsRepoInstance) {
        newsRepo = newsRepoInstance;
    }

    public void init() {
        newsRepo.readDataFromFiles();
        fetchNewsAndAuthors();
    }

    public static CNewsService instance() {
        return instance;
    }
}
