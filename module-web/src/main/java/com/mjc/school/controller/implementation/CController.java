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
    public Boolean deleteNewsEntry(Long id) {
        return newsService.deleteNewsEntry(id);
    }

    @Override
    public NewsDTO getNewsById(Long id) {
        return newsService.getNewsById(id);
    }

    @Override
    public NewsDTO createNewsEntry(NewsDTO newsDto) {
        return newsService.createNewsEntry(newsDto);
    }

    @Override
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @Override
    public NewsDTO updateNewsEntry(NewsDTO news) {
        return newsService.updateNewsEntry(news);
    }
}
