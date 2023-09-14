package com.mjc.school.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mjc.school.repository.NewsRepository;
import jdk.jshell.spi.ExecutionControl;


import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CNewsRepository implements NewsRepository {
    private static volatile CNewsRepository instance = new CNewsRepository();
    private List<NewsEntity> allNews;
    private List<AuthorEntity> allAuthors;
    private String dateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    @Override
    public boolean deleteNewsEntry(long id) {
        NewsEntity newsToDelete = getNewsById(id);
        int index = -1;
        if (allNews.contains(newsToDelete))
            index = allNews.indexOf(newsToDelete);
        else
            throw new RuntimeException("found no news object with id: " + id);
        allNews.remove(index);
        return true;
    }

    @Override
    public NewsEntity getNewsById(long id) {
        var newsEntitiesWithId = allNews.stream().filter(a -> a.getId() == id).toList();
        if (newsEntitiesWithId.size() > 1)
            throw new RuntimeException("found more than a single news object with id: " + id);
        else if (newsEntitiesWithId.size() == 0)
            throw new RuntimeException("found no news object with id: " + id);
        return newsEntitiesWithId.get(0);
    }

    @Override
    public long createNewsEntry(NewsEntity news) {
        var id = generateNewsID();
        var now = LocalDateTime.now();
        news.setId(id);
        news.setCreateDate(now);
        news.setLastUpdateDate(now);
        allNews.add(news);
        return id;
    }

    @Override
    public boolean updateNewsEntry(NewsEntity news) {
        var id = news.getId();
        int index = -1;
        if (allNews.contains(news))
            index = allNews.indexOf(news);
        else
            throw new RuntimeException("found no news object with id: " + id);
        allNews.get(index).setContent(news.getContent());
        allNews.get(index).setTitle(news.getTitle());
        allNews.get(index).setAuthorId(news.getAuthorId());
        var now = LocalDateTime.now();
        allNews.get(index).setLastUpdateDate(now);
        return true;
    }

    @Override
    public List<NewsEntity> getAllNews() {
        return allNews;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return allAuthors;
    }

    public String getDateFormatPattern() {
        return dateFormatPattern;
    }

    private long generateNewsID() {
        long largestId = allNews.stream()
                .max(Comparator.comparingLong(NewsEntity::getId)).get().getId();
        return ++largestId;
    }

    private <T> List<T> readJsonFile(String fileName, Class<T> objClass) {
        DateFormat df = new SimpleDateFormat(dateFormatPattern);
        var objMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setDateFormat(df);
        try(InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            var collectionType = objMapper.getTypeFactory().constructCollectionType(ArrayList.class, objClass);
            return objMapper.readValue(resourceStream, collectionType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from the file: " + fileName);
        }
    }

    public void readDataFromFiles() {
        allNews = readJsonFile("news.json", NewsEntity.class);
        allAuthors = readJsonFile("authors.json", AuthorEntity.class);
    }

    public void readDataFromFiles(String newsFile, String authorsFile) {
        allNews = readJsonFile(newsFile, NewsEntity.class);
        allAuthors = readJsonFile(authorsFile, AuthorEntity.class);
    }

    public boolean saveToFile() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("not implemented yet");
    }

    public static CNewsRepository instance(){
        return instance;
    }
}
