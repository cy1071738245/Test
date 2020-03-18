package com.cy.service;

import java.util.List;

import com.cy.entity.Employee;

public interface EmployeeService {

	/**
	 * 登陆验证
	 * @param employee
	 * @return Employee
	 */
	Employee loginVerifyService(Employee employee);
	
	/**
	 * 查询所有员工
	 * @return List<Employee>
	 */
	List<Employee> allEmployeeService();
	
	/**
	 * 检查用户名是否重复
	 * @param employeeUsername
	 * @return Employee
	 */
	Employee checkUsername(String employeeUsername);
	
	/**
	 * 检查昵称是否重复
	 * @param employeeUsername
	 * @return Employee
	 */
	Employee checkNickname(String employeeNickname);
	
	/**
	 * 变更员工信息
	 * @param employee
	 * @return Integer
	 */
	Integer operateUserService(Employee employee);
	
	/**
	 * 重置密码
	 * @param employeeId
	 * @return Integer
	 */
	Integer resetPasswordService(Integer employeeId);
	
	/**
	 * 修改密码
	 * @param employeeId
	 * @return Integer
	 */
	Integer updatePasswordService(String password, Employee employee);
	
	/**
	 * 搜索
	 * @param keyWord
	 * @return List<Employee>
	 */
	List<Employee> searchEmployeeService(String keyWord);
	
}
