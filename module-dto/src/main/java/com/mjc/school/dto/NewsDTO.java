package com.mjc.school.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class NewsDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;
    private static final String dateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    @Override
    public String toString() {
        return "[" + id + "] " + title + ". created: " +
                createDate.format(DateTimeFormatter.ofPattern(dateFormatPattern)) + ". modified: " +
                lastUpdateDate.format(DateTimeFormatter.ofPattern(dateFormatPattern)) + ". author: " +
                authorId + ". " + content;
    }
}
