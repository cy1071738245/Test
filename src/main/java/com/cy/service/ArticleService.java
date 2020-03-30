package com.cy.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ArticleService
 * @Description: TODO
 * @date 2020/3/26 16:32
 */
public interface ArticleService {

	Map<String, Object> getArticleList(Integer poetryId, int page, int size, String keyword);

	List<Map<String, Object>> loadPoetryInfo();

	void addArticle(String title, int userId, String content, String imageUrl, int poetryId);

	void editArticle(int articleId, String title, int userId, String content, String imageUrl, int poetryId);

	void deleteArticle(int articleId);

	void batchDeleteArticle(List<Integer> articleIds);

	Map<String, Object> getArticleById(int articleId);

}
