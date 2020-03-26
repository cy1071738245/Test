package com.cy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.mapper.PoetryMapper;
import com.cy.service.PoetryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class PoetryServiceImpl implements PoetryService {

	@Resource
	private PoetryMapper poetryMapper;

	@Override
	public Map<String, Object> getPoetryList(int page, int size, String keyword) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> poetryList = poetryMapper.getPoetryList(page, size, keyword);
		int poetryListCount = poetryMapper.getPoetryListCount(keyword);
		Integer prePage = page < 2 ? null : page - 1;
		Integer nextPage = page + 1 > ((poetryListCount % size) == 0
					? poetryListCount / size
					: poetryListCount / size + 1)
				? null : page + 1;
		result.put("data", poetryList);
		result.put("prePage", prePage);
		result.put("nextPage", nextPage);
		return result;
	}

	@Override
	public void addPoetry(String poetryName, int authorId, String content, String imageUrl) {
		poetryMapper.addPoetry(poetryName, authorId, content, imageUrl);
	}

	@Override
	public void editPoetry(int poetryId, String poetryName, int authorId, String content, String imageUrl) {
		poetryMapper.editPoetry(poetryId, poetryName, authorId, content, imageUrl);
	}

	@Override
	public void deletePoetry(int poetryId) {
		poetryMapper.deletePoetry(poetryId);
	}

}
