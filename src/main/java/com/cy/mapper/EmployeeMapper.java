package com.cy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cy.entity.Employee;

public interface EmployeeMapper {

	/**
	 * 登陆验证
	 * @param employee
	 * @return Employee
	 */
	Employee loginVerify(@Param("employee")Employee employee);
	
	/**
	 * 查询所有员工
	 * @return List<Employee>
	 */
	List<Employee> allEmployee();
	
	/**
	 * 检查用户名是否重复
	 * @param employeeUsername
	 * @return Employee
	 */
	Employee checkUsername(@Param("employeeUsername")String employeeUsername);
	
	/**
	 * 检查昵称是否重复
	 * @param employeeUsername
	 * @return Employee
	 */
	Employee checkNickname(@Param("employeeNickname")String employeeNickname);
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return Integer
	 */
	Integer updateEmployee(@Param("employee")Employee employee);
	
	/**
	 * 新增员工信息
	 * @param employee
	 * @return Integer
	 */
	Integer insertEmployee(@Param("employee")Employee employee);
	
	/**
	 * 删除员工信息
	 * @param employee
	 * @return Integer
	 */
	Integer deleteEmployee(@Param("employee")Employee employee);
	
	/**
	 * 重置密码
	 * @param employeeId
	 * @return Integer
	 */
	Integer resetPassword(@Param("employeeId")Integer employeeId);
	
	/**
	 * 修改密码
	 * @param password
	 * @param employee
	 * @return Integer
	 */
	Integer updatePassword(@Param("password")String password, @Param("employee")Employee employee);
	
	/**
	 * 搜索
	 * @param keyWord
	 * @return List<Employee>
	 */
	List<Employee> searchEmployee(@Param("keyWord")String keyWord);
	
}
