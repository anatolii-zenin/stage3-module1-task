package com.mjc.school.controller;

import com.mjc.school.service.NewsDTO;

import java.util.List;

public class CController implements Controller {

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
}
