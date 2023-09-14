package com.mjc.school.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mjc.school.repository.models.AuthorModel;
import com.mjc.school.repository.models.NewsModel;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private List<NewsModel> allNews;
    private List<AuthorModel> allAuthors;

    private final String dateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public String getDateFormatPattern() {
        return dateFormatPattern;
    }

    public <T> List<T> readJsonFile(String fileName, Class<T> objClass) {
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

    private void readDataFromFiles() {
        allNews = readJsonFile("news.json", NewsModel.class);
        allAuthors = readJsonFile("authors.json", AuthorModel.class);
    }

    private void readDataFromFiles(String newsFile, String authorsFile) {
        allNews = readJsonFile(newsFile, NewsModel.class);
        allAuthors = readJsonFile(authorsFile, AuthorModel.class);
    }

    public DataSource() {
        readDataFromFiles();
    }

    public DataSource(String newsFileName, String authorsFileName) {
        readDataFromFiles(newsFileName, authorsFileName);
    }

    public List<NewsModel> getNewsData() {
        return allNews;
    }

    public List<AuthorModel> getAuthorsData() {
        return allAuthors;
    }
}
