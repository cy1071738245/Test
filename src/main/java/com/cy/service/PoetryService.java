package com.cy.service;

import java.util.List;
import java.util.Map;

public interface PoetryService {

    Map<String, Object> getPoetryList(int page, int size, String keyword);

    Map<String, List<Map<String, Object>>> loadAuthorInfo();

    void addPoetry(String poetryName, int authorId, String content, String imageUrl);

    void editPoetry(int poetryId, String poetryName, int authorId, String content, String imageUrl);

    void deletePoetry(int poetryId);

    void batchDeletePoetry(List<Integer> poetryIds);

}
