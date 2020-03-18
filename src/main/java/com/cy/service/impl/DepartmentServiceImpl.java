package com.cy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.entity.Department;
import com.cy.mapper.DepartmentMapper;
import com.cy.service.DepartmentService;

@Service("departmentService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class DepartmentServiceImpl implements DepartmentService {

	@Resource(name="departmentMapper")
	private DepartmentMapper departmentMapper;
	
	/**
	 * 查询所有部门
	 */
	@Override
	public List<Department> allDepartmentService() {
		
		List<Department> result = departmentMapper.allDepartment();
		
		return result;
	}

	/**
	 * 检查部门名是否重复
	 */
	@Override
	public Department checkDepartmentName(String departmentName) {

		Department result = departmentMapper.checkDepartmentName(departmentName);
		
		return result;
	}
	
	/**
	 * 变更部门信息
	 */
	@Override
	public Integer operateDepartService(Department department) {

		Integer result = 0;
		
		if(department.getDepartmentId() != null && department.getDepartmentName() != null) {
			result = departmentMapper.updateDepartment(department);
		}else if(department.getDepartmentId() != null && department.getDepartmentName() == null){
			
			//如果删除的是技术部则不予删除
			if(department.getDepartmentId() == 1) {
				return -2;
			}
			
			result = departmentMapper.deleteDepartment(department);
		}else {
			result = departmentMapper.insertDepartment(department);
		}
		
		return result;
	}

	/**
	 * 搜索
	 */
	@Override
	public List<Department> searchDepartmentService(String keyWord) {

		List<Department> result = departmentMapper.searchDepartment(keyWord);
		
		return result;
	}

}
