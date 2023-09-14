package com.mjc.school.controller.implementation;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.implementation.CNewsService;
import com.mjc.school.dto.NewsDTO;
import com.mjc.school.service.NewsService;

import java.util.List;

public class CController implements Controller {
    private final NewsService newsService = CNewsService.instance();

    public void init() {
        newsService.init();
    }

    @Override
    public boolean deleteNewsEntry(long id) {
        return newsService.deleteNewsEntry(id);
    }

    @Override
    public NewsDTO getNewsById(long id) {
        return newsService.getNewsById(id);
    }

    @Override
    public long createNewsEntry(NewsDTO newsDto) {
        return newsService.createNewsEntry(newsDto);
    }

    @Override
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @Override
    public boolean updateNewsEntry(NewsDTO news) {
        return newsService.updateNewsEntry(news);
    }
}
