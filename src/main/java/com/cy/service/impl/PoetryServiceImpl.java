package com.cy.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.cy.mapper.AuthorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.mapper.PoetryMapper;
import com.cy.service.PoetryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class PoetryServiceImpl implements PoetryService {

	@Resource
	private PoetryMapper poetryMapper;
	@Resource
	private AuthorMapper authorMapper;

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
	public Map<String, List<Map<String, Object>>> loadAuthorInfo() {
		Map<String, List<Map<String, Object>>> result = new HashMap<>();
		List<Map<String, Object>> authorInfos = authorMapper.getAuthorLoading();
		authorInfos.forEach(info -> {
			String dynasty = (String) info.get("dynasty");
			if (nonNull(result.get(dynasty))) {
				result.get(dynasty).add(info);
			} else {
				List<Map<String, Object>> list = new ArrayList<>();
				list.add(info);
				result.put(dynasty, list);
			}
		});
		return result;
	}

	@Override
	public void addPoetry(String poetryName, int authorId, String content, String imageUrl) {
		poetryMapper.addPoetry(poetryName, authorId, content, imageUrl);
	}

	@Override
	public JSONObject loadPoetryForEdit(int poetryId) {
		Map<String, Object> poetryInfo = poetryMapper.getPoetryByPoetryId(poetryId);
		return new JSONObject(poetryInfo);
	}

	@Override
	public void editPoetry(int poetryId, String poetryName, int authorId, String content, String imageUrl) {
		poetryMapper.editPoetry(poetryId, poetryName, authorId, content, imageUrl);
	}

	@Override
	public void deletePoetry(int poetryId) {
		poetryMapper.deletePoetry(poetryId);
	}

	@Override
	@Transactional
	public void batchDeletePoetry(List<Integer> poetryIds) {
		poetryIds.forEach(poetryId -> poetryMapper.deletePoetry(poetryId));
	}

}
