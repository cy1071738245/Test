package com.cy.entity;

import java.util.List;

/**
 * 职位信息实体类
 * @author cy
 *
 */
public class JobInfo {

	private Integer jobInfoId;
	private String jobInfoName;
	private Integer departmentId;
	
	//一对多权限关系映射
	private List<AuthorityJob> authorityJobList;
	
	//一对一权限关系映射
	private Department department;
	
	public Integer getJobInfoId() {
		return jobInfoId;
	}
	public void setJobInfoId(Integer jobInfoId) {
		this.jobInfoId = jobInfoId;
	}
	public String getJobInfoName() {
		return jobInfoName;
	}
	public void setJobInfoName(String jobInfoName) {
		this.jobInfoName = jobInfoName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	public List<AuthorityJob> getAuthorityJobList() {
		return authorityJobList;
	}
	public void setAuthorityJobList(List<AuthorityJob> authorityJobList) {
		this.authorityJobList = authorityJobList;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "JobInfo [jobInfoId=" + jobInfoId + ", jobInfoName=" + jobInfoName + ", departmentId=" + departmentId
				+ "]";
	}
	
}
