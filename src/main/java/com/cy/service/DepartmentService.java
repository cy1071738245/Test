package com.cy.service;

import java.util.List;

import com.cy.entity.Department;

public interface DepartmentService {

	/**
	 * 查询所有部门
	 * @return List<Department>
	 */
	List<Department> allDepartmentService();

	/**
	 * 检查部门名是否重复
	 * @param departmentName
	 * @return Department
	 */
	Department checkDepartmentName(String departmentName);
	
	/**
	 * 变更部门信息
	 * @param department
	 * @return Integer
	 */
	Integer operateDepartService(Department department);
	
	/**
	 * 搜索
	 * @param keyWord
	 * @return List<Department>
	 */
	List<Department> searchDepartmentService(String keyWord);
	
}
