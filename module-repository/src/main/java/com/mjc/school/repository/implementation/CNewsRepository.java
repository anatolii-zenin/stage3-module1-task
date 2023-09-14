package com.mjc.school.repository.implementation;

import com.mjc.school.repository.NewsRepository;
import jdk.jshell.spi.ExecutionControl;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class CNewsRepository implements NewsRepository {
    private static volatile CNewsRepository instance = new CNewsRepository();
    private DataSource dataSource;
    private List<NewsEntity> allNews;
    private List<AuthorEntity> allAuthors;
    @Override
    public Boolean deleteNewsEntry(long id) {
        NewsEntity newsToDelete = readByIdNews(id);
        int index = -1;
        if (allNews.contains(newsToDelete))
            index = allNews.indexOf(newsToDelete);
        else
            throw new RuntimeException("found no news object with id: " + id);
        allNews.remove(index);
        return Boolean.TRUE;
    }

    @Override
    public NewsEntity readByIdNews(long id) {
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
    public Boolean updateNewsEntry(NewsEntity news) {
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
        return Boolean.TRUE;
    }

    @Override
    public List<NewsEntity> readAllNews() {
        return allNews;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return allAuthors;
    }

    public String getDateFormatPattern() {
        return dataSource.getDateFormatPattern();
    }

    private long generateNewsID() {
        long largestId = allNews.stream()
                .max(Comparator.comparingLong(NewsEntity::getId)).get().getId();
        return ++largestId;
    }

    public boolean saveToFile() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("not implemented yet");
    }

    public static CNewsRepository instance(){
        return instance;
    }

    public void setDataSource(String newsFileName, String authorsFileName) {
        this.dataSource = new DataSource("news_test.json","authors_test.json");
        readData();
    }

    public void setDataSource() {
        this.dataSource = new DataSource();
        readData();
    }

    public void readData() {
        allNews = dataSource.getNewsData();
        allAuthors = dataSource.getAuthorsData();
    }

    private CNewsRepository() {
    }
}