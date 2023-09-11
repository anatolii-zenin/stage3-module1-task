package com.mjc.school.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsServiceTests {
    @Test
    public void entityToDtoTest() {
        NewsService newsService = CNewsService.instance();
        CNewsService.instance().init("news_test.json","authors_test.json");
        var testDto = newsService.getAllNews().get(0);
        assertEquals(0, testDto.getId());
        assertEquals("testNews", testDto.getContent());
        assertEquals("testNews", testDto.getTitle());
        assertEquals("testAuthor", testDto.getAuthorName());
        assertEquals("2001-05-03T00:00:00.000", testDto.getCreateDate());
        assertEquals("2011-05-03T00:00:00.000", testDto.getLastUpdateDate());
    }
}
