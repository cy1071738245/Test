package com.cy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.entity.Employee;
import com.cy.mapper.EmployeeMapper;
import com.cy.service.EmployeeService;

@Service("employeeService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class EmployeeServiceImpl implements EmployeeService {

	@Resource(name="employeeMapper")
	private EmployeeMapper employeeMapper;
	
	/**
	 * 登录验证
	 */
	@Override
	public Employee loginVerifyService(Employee employee) {
		
		Employee result = employeeMapper.loginVerify(employee);
		
		return result;
	}

	/**
	 * 查询所有员工
	 */
	@Override
	public List<Employee> allEmployeeService() {

		List<Employee> result = employeeMapper.allEmployee();
		
		return result;
	}

	/**
	 * 变更员工信息
	 */
	@Override
	public Integer operateUserService(Employee employee) {

		Integer result = 0;
		
		if(employee.getEmployeeId() != null && employee.getEmployeeUsername() != null){
			result = employeeMapper.updateEmployee(employee);
		}else if(employee.getEmployeeId() != null && employee.getEmployeeUsername() == null) {
			
			//如果删除的是超级管理员则不予删除
			if(employee.getJobinfoId() == 1) {
				return -2;
			}
			
			result = employeeMapper.deleteEmployee(employee);
		}else {
			result = employeeMapper.insertEmployee(employee);
		}
		
		return result;
	}

	/**
	 * 检查用户名是否重复
	 */
	@Override
	public Employee checkUsername(String employeeUsername) {

		Employee result = employeeMapper.checkUsername(employeeUsername);
		
		return result;
	}

	
	/**
	 * 检查昵称是否重复
	 */
	@Override
	public Employee checkNickname(String employeeNickname) {

		Employee result = employeeMapper.checkNickname(employeeNickname);
		
		return result;
	}

	/**
	 * 重置密码
	 */
	@Override
	public Integer resetPasswordService(Integer employeeId) {

		Integer result = employeeMapper.resetPassword(employeeId);
		
		return result;
	}

	/**
	 * 修改密码
	 */
	@Override
	public Integer updatePasswordService(String password, Employee employee) {

		Integer result = employeeMapper.updatePassword(password, employee);
		
		return result;
	}

	/**
	 * 搜索
	 */
	@Override
	public List<Employee> searchEmployeeService(String keyWord) {
		
		List<Employee> result = employeeMapper.searchEmployee(keyWord);
		
		return result;
	}

}
