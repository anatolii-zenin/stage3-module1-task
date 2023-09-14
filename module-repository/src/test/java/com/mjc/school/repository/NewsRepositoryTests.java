package com.mjc.school.repository;

import com.mjc.school.repository.implementation.CNewsRepository;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsRepositoryTests {
    @Test
    public void readFileTest() {
        NewsRepository repo = CNewsRepository.instance();
        repo.readDataFromFiles("news_test.json","authors_test.json");
        var newsEntry = repo.getAllNews().get(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CNewsRepository.instance().getDateFormatPattern());
        assertEquals(0, newsEntry.getId());
        assertEquals("testNews", newsEntry.getTitle());
        assertEquals("testNews", newsEntry.getContent());
        assertEquals("2001-05-03T00:00:00.000", newsEntry.getCreateDate().format(formatter));
        assertEquals("2011-05-03T00:00:00.000", newsEntry.getLastUpdateDate().format(formatter));
        assertEquals(0, newsEntry.getAuthorId());

        var authorEntry = repo.getAllAuthors().get(0);
        assertEquals(0, authorEntry.getId());
        assertEquals("testAuthor", authorEntry.getName());
    }
}
