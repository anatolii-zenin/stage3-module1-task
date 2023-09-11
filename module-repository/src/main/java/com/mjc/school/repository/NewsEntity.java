package com.mjc.school.repository;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect
@Setter
@Getter
public class NewsEntity {
    private long id;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime lastUpdateDate;
    private long authorId;

    @Override
    public String toString() {
        return "[" + id + "] " + title + ". created: " + createDate + ". modified: " +
                lastUpdateDate + ". author: " + authorId + ". " + content;
    }
}
