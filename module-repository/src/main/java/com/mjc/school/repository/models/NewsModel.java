package com.mjc.school.repository.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect
@Setter
@Getter
public class NewsModel {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    @Override
    public String toString() {
        return "[" + id + "] " + title + ". created: " + createDate + ". modified: " +
                lastUpdateDate + ". author: " + authorId + ". " + content;
    }

    @Override
    public boolean equals(Object newsEntityObj) {
        if (!(newsEntityObj instanceof NewsModel otherNews))
            return false;
        return this.id == otherNews.id;
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
