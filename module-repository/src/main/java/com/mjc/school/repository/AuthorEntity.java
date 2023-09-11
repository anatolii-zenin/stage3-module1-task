package com.mjc.school.repository;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorEntity {
    private long id;
    private String name;

    @Override
    public String toString() {
        return "[" + id + "] name:" + name;
    }
}