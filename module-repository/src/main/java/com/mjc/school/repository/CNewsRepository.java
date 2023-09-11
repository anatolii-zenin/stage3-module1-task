package com.mjc.school.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jdk.jshell.spi.ExecutionControl;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CNewsRepository implements NewsRepository {
    private volatile CNewsRepository instance;
    private List<NewsEntity> allNews;
    private List<AuthorEntity> allAuthors;
    @Override
    public boolean deleteNewsEntry(long id) {
        return false;
    }

    @Override
    public NewsEntity getNewsById(long id) {
        return null;
    }

    @Override
    public int createNewsEntry(NewsEntity news) {
        return 0;
    }

    @Override
    public boolean updateNewsEntry(NewsEntity news) {
        return false;
    }

    @Override
    public List<NewsEntity> getAllNews() {
        return allNews;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return allAuthors;
    }

    private int AddAuthor(String authorName) {
        return 0;
    }

    private <T> List<T> readJsonFile(String fileName, Class<T> objClass) {
        var objMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
        try(InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            var collectionType = objMapper.getTypeFactory().constructCollectionType(ArrayList.class, objClass);
            List<T> objList = objMapper.readValue(resourceStream, collectionType);
            return objList;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from the file: " + fileName);
        }
    }

    public CNewsRepository() {
        allNews = readJsonFile("news.json", NewsEntity.class);
        allAuthors = readJsonFile("authors.json", AuthorEntity.class);
    }

    public CNewsRepository(String newsFile, String authorsFile) {
        allNews = readJsonFile(newsFile, NewsEntity.class);
        allAuthors = readJsonFile(authorsFile, AuthorEntity.class);
    }

    public boolean saveToFile() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("not implemented yet");
    }
}
