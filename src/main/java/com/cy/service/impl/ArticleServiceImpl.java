package com.cy.service.impl;

import com.cy.mapper.ArticleMapper;
import com.cy.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenyu
 * @ClassName: ArticleServiceImpl
 * @Description: TODO
 * @date 2020/3/26 16:41
 */
@Service
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;

	@Override
	public Map<String, Object> getArticleList(int page, int size, String keyword) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> articleList = articleMapper.getArticleList(page, size, keyword);
		int articleListCount = articleMapper.getArticleListCount(keyword);
		Integer prePage = page < 2 ? null : page - 1;
		Integer nextPage = page + 1 > ((articleListCount % size) == 0
				? articleListCount / size
				: articleListCount / size + 1)
				? null : page + 1;
		result.put("data", articleList);
		result.put("prePage", prePage);
		result.put("nextPage", nextPage);
		return result;
	}

	@Override
	public void addArticle(String title, int userId, String content, String imageUrl, int poetryId) {
		articleMapper.addArticle(title, userId, content, imageUrl, poetryId);
	}

	@Override
	public void editArticle(int articleId, String title, int userId, String content, String imageUrl, int poetryId) {
		articleMapper.editArticle(articleId, title, userId, content, imageUrl, poetryId);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleMapper.deleteArticle(articleId);
	}

}