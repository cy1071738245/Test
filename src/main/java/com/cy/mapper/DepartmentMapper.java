package com.cy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cy.entity.Department;

public interface DepartmentMapper {

	/**
	 * 查询所有部门
	 * @return List<Department>
	 */
	List<Department> allDepartment();
	
	/**
	 * 检查部门名是否重复
	 * @param departmentName
	 * @return Department
	 */
	Department checkDepartmentName(@Param("departmentName")String departmentName);
	
	/**
	 * 修改部门信息
	 * @param department
	 * @return Integer
	 */
	Integer updateDepartment(@Param("department")Department department);
	
	/**
	 * 新增部门信息
	 * @param department
	 * @return Integer
	 */
	Integer insertDepartment(@Param("department")Department department);
	
	/**
	 * 删除部门信息
	 * @param department
	 * @return Integer
	 */
	Integer deleteDepartment(@Param("department")Department department);
	
	/**
	 * 搜索
	 * @param keyWord
	 * @return List<Department>
	 */
	List<Department> searchDepartment(@Param("keyWord")String keyWord);
	
}
