package com.cy.service;

import java.util.Map;

public interface PoetryService {

    Map<String, Object> getPoetryList(int page, int size);

    void addPoetry(String poetryName, int authorId, String content, String imageUrl);

}
