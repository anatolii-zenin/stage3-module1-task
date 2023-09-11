package com.mjc.school.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorDTO {
    private long id;
    private String name;

    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder {
        private AuthorDTO newAuthorDTO = new AuthorDTO();
        public Builder setId(long id) {
            newAuthorDTO.id = id;
            return this;
        }
        public Builder setName(String name) {
            newAuthorDTO.name = name;
            return this;
        }
        public AuthorDTO build() {
            return newAuthorDTO;
        }
    }
}
