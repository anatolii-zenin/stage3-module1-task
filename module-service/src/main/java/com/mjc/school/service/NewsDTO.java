package com.mjc.school.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewsDTO {
    private long id;
    private String title;
    private String content;
    private String createDate;
    private String lastUpdateDate;
    private String authorName;

    @Override
    public String toString() {
        return "[" + id + "] " + title + ". created: " + createDate + ". modified: " +
                lastUpdateDate + ". author: " + authorName + ". " + content;
    }

    public static NewsDTO.Builder getBuilder() {
        return new NewsDTO.Builder();
    }
    public static class Builder {
        private NewsDTO newNewsDTO = new NewsDTO();
        public NewsDTO.Builder setId(long id) {
            newNewsDTO.id = id;
            return this;
        }
        public NewsDTO.Builder setTitle(String title) {
            newNewsDTO.title = title;
            return this;
        }
        public NewsDTO.Builder setContent(String content) {
            newNewsDTO.content = content;
            return this;
        }
        public NewsDTO.Builder setCreateDate(String date) {
            newNewsDTO.createDate = date;
            return this;
        }
        public NewsDTO.Builder setLastUpdateDate(String date) {
            newNewsDTO.lastUpdateDate = date;
            return this;
        }
        public NewsDTO.Builder setAuthor(String name) {
            newNewsDTO.authorName = name;
            return this;
        }
        public NewsDTO build() {
            return newNewsDTO;
        }
    }
}
