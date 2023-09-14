package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.NewsEntity;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.implementation.CNewsRepository;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.service.NewsMapper;
import com.mjc.school.service.NewsService;

import java.util.ArrayList;
import java.util.List;

public class CNewsService implements NewsService {
    private static volatile CNewsService instance = new CNewsService();
    private NewsRepository newsRepo = CNewsRepository.instance();
    private String status = "created";
    private List<NewsDTO> news = new ArrayList<>();
    @Override
    public boolean deleteNewsEntry(long id) {
        return newsRepo.deleteNewsEntry(id);
    }

    @Override
    public NewsDTO getNewsById(long id) {
        return entityToDto(newsRepo.getNewsById(id));
    }

    @Override
    public long createNewsEntry(NewsDTO news) {
        return newsRepo.createNewsEntry(dtoToEntity(news));
    }

    @Override
    public List<NewsDTO> getAllNews() {
        fetchNews();
        return news;
    }

    @Override
    public boolean updateNewsEntry(NewsDTO news) {
        return newsRepo.updateNewsEntry(dtoToEntity(news));
    }

    private NewsEntity dtoToEntity(NewsDTO newsDto) {
        return NewsMapper.instance.newsDtoToEntity(newsDto);
    }

    private NewsDTO entityToDto(NewsEntity newsEntity) {
        return NewsMapper.instance.newsToNewsDto(newsEntity);
    }

    private void fetchNews() {
        var newsEntities = newsRepo.getAllNews();

        int newsCounter = 0;
        for (var newsEntity : newsEntities) {
            news.add(entityToDto(newsEntity));
            newsCounter++;
        }

        System.out.println("fetched news: " + newsCounter);
    }

    public void setNewsRepo(NewsRepository newsRepoInstance) {
        newsRepo = newsRepoInstance;
    }

    public void init() {
        if (!status.equals("initialised")) {
            newsRepo.readDataFromFiles();
            status = "initialised";
        }
    }

    public static CNewsService instance() {
        return instance;
    }
}
