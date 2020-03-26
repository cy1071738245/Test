package com.cy.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ArticleMapper
 * @Description: TODO
 * @date 2020/3/26 17:06
 */
@Repository
public interface ArticleMapper {

	List<Map<String, Object>> getArticleList(@Param("page") int page, @Param("size") int size, @Param("keyword") String keyword);

	int getArticleListCount(@Param("keyword") String keyword);

	int addArticle(@Param("title") String title, @Param("userId") int userId, @Param("content") String content,
	               @Param("imageUrl") String imageUrl, @Param("poetryId") int poetryId);

	int editArticle(@Param("articleId") int articleId, @Param("title") String title, @Param("userId") int userId,
	                @Param("content") String content, @Param("imageUrl") String imageUrl, @Param("poetryId") int poetryId);

	int deleteArticle(@Param("articleId") int articleId);

}
