package com.cy.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PoetryMapper {

    List<Map<String, Object>> getPoetryList(@Param("page") int page, @Param("size") int size, @Param("keyword") String keyword);

    int getPoetryListCount(@Param("keyword") String keyword);

    int addPoetry(@Param("poetryName") String poetryName, @Param("authorId") int authorId,
                  @Param("content") String content, @Param("imageUrl") String imageUrl);

    Map<String, Object> getPoetryByPoetryId(@Param("poetryId") int poetryId);

    int editPoetry(@Param("poetryId") int poetryId, @Param("poetryName") String poetryName, @Param("authorId") int authorId,
                  @Param("content") String content, @Param("imageUrl") String imageUrl);

    int deletePoetry(@Param("poetryId") int poetryId);

}
