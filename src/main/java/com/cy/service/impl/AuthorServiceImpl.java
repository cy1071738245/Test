package com.cy.service.impl;

import com.cy.mapper.AuthorMapper;
import com.cy.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: AuthorServiceImpl
 * @Description: TODO
 * @date 2020/3/25 17:05
 */
@Service
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
public class AuthorServiceImpl implements AuthorService {

	@Resource
	private AuthorMapper authorMapper;

	@Override
	public Map<String, Object> getAuthorList(int page, int size, String keyword) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> authorList = authorMapper.getAuthorList(page, size, keyword);
		int authorListCount = authorMapper.getAuthorListCount(keyword);
		Integer prePage = page < 2 ? null : page - 1;
		Integer nextPage = page + 1 > ((authorListCount % size) == 0
				? authorListCount / size
				: authorListCount / size + 1)
				? null : page + 1;
		result.put("data", authorList);
		result.put("prePage", prePage);
		result.put("nextPage", nextPage);
		return result;
	}

	@Override
	public void addAuthor(String authorName, String sex, String dynasty, String description) {
		authorMapper.addAuthor(authorName, sex, dynasty, description);
	}

	@Override
	public void editAuthor(int authorId, String authorName, String sex, String dynasty, String description) {
		authorMapper.editAuthor(authorId, authorName, sex, dynasty, description);
	}

	@Override
	public void deleteAuthor(int authorId) {
		authorMapper.deleteAuthor(authorId);
	}

	@Override
	@Transactional
	public void batchDeleteAuthor(List<Integer> authorIds) {
		authorIds.forEach(authorId -> authorMapper.deleteAuthor(authorId));
	}

}
