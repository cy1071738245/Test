package com.cy.service;

import java.util.Map;

public interface PoetryService {

    Map<String, Object> getPoetryList(int page, int size, String keyword);

    void addPoetry(String poetryName, int authorId, String content, String imageUrl);

    void editPoetry(int poetryId, String poetryName, int authorId, String content, String imageUrl);

    void deletePoetry(int poetryId);

}
