package com.cy.entity;

/**
 * 员工实体类
 * @author cy
 *
 */
public class Employee {

	private Integer employeeId;
	private String employeeUsername;
	private String employeePassword;
	private String employeeNickname;
	private String employeeRealname;
	private Integer jobinfoId;
	private Integer departmentId;
	private String employeePhone;
	private String officeTel;
	private Integer workStatus;
	
	//职位关系映射
	private JobInfo jobInfo;
	
	//部门关系映射
	private Department department;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeUsername() {
		return employeeUsername;
	}
	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeNickname() {
		return employeeNickname;
	}
	public void setEmployeeNickname(String employeeNickname) {
		this.employeeNickname = employeeNickname;
	}
	public String getEmployeeRealname() {
		return employeeRealname;
	}
	public void setEmployeeRealname(String employeeRealname) {
		this.employeeRealname = employeeRealname;
	}
	public Integer getJobinfoId() {
		return jobinfoId;
	}
	public void setJobinfoId(Integer jobinfoId) {
		this.jobinfoId = jobinfoId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public Integer getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(Integer workStatus) {
		this.workStatus = workStatus;
	}
	
	public JobInfo getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeUsername=" + employeeUsername + ", employeePassword="
				+ employeePassword + ", employeeNickname=" + employeeNickname + ", employeeRealname=" + employeeRealname
				+ ", jobinfoId=" + jobinfoId + ", departmentId=" + departmentId + ", employeePhone=" + employeePhone
				+ ", officeTel=" + officeTel + ", workStatus=" + workStatus + "]";
	}
	
}
