package com.cy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.entity.Authority;
import com.cy.entity.AuthorityJob;
import com.cy.entity.Employee;
import com.cy.mapper.AboutAuthorityMapper;
import com.cy.service.AboutAuthorityService;

@Service("aboutAuthorityService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class AboutAuthorityServiceImpl implements AboutAuthorityService {

	@Resource(name="aboutAuthorityMapper")
	private AboutAuthorityMapper aboutAuthorityMapper;
	
	/**
	 * 返回该用户的所有权限
	 */
	@Override
	public Employee loadAuthorityService(Employee employee) {
		
		Employee result = aboutAuthorityMapper.loadAuthority(employee);
		
		return result;
	}

	/**
	 * 返回所有的一级权限和二级权限的List
	 */
	@Override
	public List<Map<String, Object>> queryAllLevelAuthorityService() {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		List<Authority> result1 = aboutAuthorityMapper.queryFirstLevelAuthority();
		for (Authority authority1 : result1) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Authority> result2 = aboutAuthorityMapper.querySecondLevelAuthority(authority1.getAuthorityId());
			map.put("first", authority1);
			map.put("second", result2);
			list.add(map);
		}
		
		return list;
	}

	/**
	 * 查询该职位的所有权限id
	 */
	@Override
	public List<AuthorityJob> queryRoleAuthorityIdService(Integer jobInfoId) {

		List<AuthorityJob> result = aboutAuthorityMapper.queryRoleAuthorityId(jobInfoId);
		
		return result;
	}

	/**
	 * 分配权限
	 */
	@Override
	public Integer assignAuthorityService(Integer jobInfoId, String[] authorityArr) {
		
		//判断是否是改管理员权限并且是否取消了 部门管理(id=1)、职位管理(id=2)、员工管理(id=3)三个基本权限，如果有则返回-2不予更改
		if(jobInfoId == 1) {
			if(!(Arrays.asList(authorityArr).contains("1") && Arrays.asList(authorityArr).contains("2") && Arrays.asList(authorityArr).contains("3"))) {
				return -2;
			}
		}
		
		aboutAuthorityMapper.deletePersonalAuthority(jobInfoId);
		
		int insertNum = 0;
		
		if(authorityArr != null) {
			for (String authorityId : authorityArr) {
				AuthorityJob authorityJob = new AuthorityJob();
				authorityJob.setJobInfoId(jobInfoId);
				authorityJob.setAuthorityId(Integer.parseInt(authorityId));
				
				Integer result = aboutAuthorityMapper.insertPersonalAuthority(authorityJob);
				
				insertNum = insertNum + result;
			}
		}
		
		return insertNum;
	}

}
