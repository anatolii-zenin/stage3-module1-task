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
    private static volatile DataSource instance = new DataSource();
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

    private DataSource() {
        readDataFromFiles();
    }

    public List<NewsModel> getNewsData() {
        return allNews;
    }

    public List<AuthorModel> getAuthorsData() {
        return allAuthors;
    }

    public static DataSource getInstance() {
        return instance;
    }
}
