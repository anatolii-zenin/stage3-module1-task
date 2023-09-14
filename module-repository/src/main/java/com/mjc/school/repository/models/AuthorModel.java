package com.mjc.school.repository.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorModel {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "[" + id + "] name:" + name;
    }
}
