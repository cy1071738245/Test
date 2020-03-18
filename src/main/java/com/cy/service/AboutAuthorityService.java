package com.cy.service;

import java.util.List;
import java.util.Map;

import com.cy.entity.AuthorityJob;
import com.cy.entity.Employee;

public interface AboutAuthorityService {

	/**
	 * 返回该用户的所有权限
	 * @param employee
	 * @return Employee
	 */
	Employee loadAuthorityService(Employee employee);
	
	/**
	 * 返回所有的一级权限和二级权限的map
	 * @return List<Map<String, Object>>
	 */
	List<Map<String, Object>> queryAllLevelAuthorityService();
	
	/**
	 * 查询该职位的所有权限id
	 * @param jobInfoId
	 * @return List<AuthorityJob>
	 */
	List<AuthorityJob> queryRoleAuthorityIdService(Integer jobInfoId);
	
	/**
	 * 分配权限
	 * @param authorityArr
	 * @return Integer
	 */
	Integer assignAuthorityService(Integer jobInfoId, String[] authorityArr);
	
}
