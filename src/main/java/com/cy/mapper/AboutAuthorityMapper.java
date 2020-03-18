package com.cy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cy.entity.Authority;
import com.cy.entity.AuthorityJob;
import com.cy.entity.Employee;

public interface AboutAuthorityMapper {

	/**
	 * 返回该用户的所有权限
	 * @param employee
	 * @return Employee
	 */
	Employee loadAuthority(@Param("employee")Employee employee);
	
	/**
	 * 查询所有一级权限
	 * @return List<Authority>
	 */
	List<Authority> queryFirstLevelAuthority();
	
	/**
	 * 查询所有二级权限
	 * @return List<Authority>
	 */
	List<Authority> querySecondLevelAuthority(@Param("authorityId")Integer authorityId);
	
	/**
	 * 查询该职位的所有权限id
	 * @param jobInfoId
	 * @return List<AuthorityJob>
	 */
	List<AuthorityJob> queryRoleAuthorityId(@Param("jobInfoId")Integer jobInfoId);
	
	/**
	 * 暂时删除该职位的所有旧权限
	 * @param jobInfoId
	 * @return Integer
	 */
	Integer deletePersonalAuthority(@Param("jobInfoId")Integer jobInfoId);
	
	/**
	 * 插入该职位的新权限
	 * @param authorityJob
	 * @return Integer
	 */
	Integer insertPersonalAuthority(@Param("authorityJob")AuthorityJob authorityJob);
	
}
