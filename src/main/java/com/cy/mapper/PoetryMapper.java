package com.cy.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PoetryMapper {

    List<Map<String, Object>> getPoetryList(@Param("page") int page, @Param("size") int size);

    int getPoetryListCount();

}
