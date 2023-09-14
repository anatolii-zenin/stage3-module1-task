package com.mjc.school.service;

import com.mjc.school.dto.NewsDTO;
import com.mjc.school.repository.models.NewsModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {
    NewsMapper instance = Mappers.getMapper(NewsMapper.class);
    NewsDTO newsToNewsDto(NewsModel newsModel);
    NewsModel newsDtoToEntity(NewsDTO newsDTO);
}