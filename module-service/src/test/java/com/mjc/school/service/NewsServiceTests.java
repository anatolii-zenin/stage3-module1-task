package com.mjc.school.service;

import com.mjc.school.repository.implementation.AuthorEntity;
import com.mjc.school.repository.implementation.CNewsRepository;
import com.mjc.school.repository.implementation.NewsEntity;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.service.implementation.CNewsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewsServiceTests {
    private NewsRepository newsRepoMock;
    private NewsService newsService;
    private String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    private List<NewsEntity> getMockNews() {
        var newsEntityListMock = new ArrayList<NewsEntity>();
        newsEntityListMock.add(getMockNewsEntity(0));
        return newsEntityListMock;
    }

    private List<AuthorEntity> getMockAuthors() {
        var authorEntityListMock = new ArrayList<AuthorEntity>();
        authorEntityListMock.add(getMockAuthorEntity(0));
        return authorEntityListMock;
    }

    private NewsEntity getMockNewsEntity(int id) {
        var newsEntry = new NewsEntity();
        var createDate = "2001-01-01T01:01:01.001";
        var lastUpdateDate = "2005-05-05T05:05:05.005";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        newsEntry.setId(id);
        newsEntry.setTitle("mockTitle");
        newsEntry.setContent("mockContent");
        newsEntry.setAuthorId(0);
        newsEntry.setCreateDate(LocalDateTime.parse(createDate, formatter));
        newsEntry.setLastUpdateDate(LocalDateTime.parse(lastUpdateDate, formatter));
        return newsEntry;
    }

    private AuthorEntity getMockAuthorEntity(int id) {
        var authorEntity = new AuthorEntity();
        authorEntity.setId(id);
        authorEntity.setName("mockAuthor");
        return authorEntity;
    }

    @BeforeEach
    public void setup() {
        newsRepoMock = mock(CNewsRepository.class);
        newsService = CNewsService.instance();
        CNewsService.instance().setNewsRepo(newsRepoMock);
    }
    @Test
    public void entityToDtoTest() {
        when(newsRepoMock.getAllNews()).thenReturn(getMockNews());
        when(newsRepoMock.getAllAuthors()).thenReturn(getMockAuthors());
        when(newsRepoMock.getDateFormatPattern()).thenReturn(dateTimeFormat);
        newsService.init();
        var testDto = newsService.getAllNews().get(0);
        assertEquals(0, testDto.getId());
        assertEquals("mockContent", testDto.getContent());
        assertEquals("mockTitle", testDto.getTitle());
//        assertEquals("mockAuthor", testDto.getAuthorName());
//        assertEquals("2001-01-01T01:01:01.001", testDto.getCreateDate());
//        assertEquals("2005-05-05T05:05:05.005", testDto.getLastUpdateDate());
    }
}
