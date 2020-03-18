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

@Service("customerService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class PoetryServiceImpl implements PoetryService {

	@Resource
	private PoetryMapper poetryMapper;

	@Override
	public Map<String, Object> getPoetryList(int page, int size) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> poetryList = poetryMapper.getPoetryList(page, size);
		int poetryListCount = poetryMapper.getPoetryListCount();
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

}
