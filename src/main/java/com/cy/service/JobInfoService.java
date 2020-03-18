package com.cy.service;

import java.util.List;

import com.cy.entity.JobInfo;

public interface JobInfoService {

	/**
	 * 查询所有职位
	 * @return List<JobInfo>
	 */
	List<JobInfo> allJobInfoService();
	
	/**
	 * 检查职位名是否重复
	 * @param jobInfoName
	 * @return JobInfo
	 */
	JobInfo checkJobInfoName(String jobInfoName);
	
	/**
	 * 变更职位信息
	 * @param jobInfo
	 * @return Integer
	 */
	Integer operateRoleService(JobInfo jobInfo);
	
	/**
	 * 根据职位id查询部门信息
	 * @param jobInfoId
	 * @return JobInfo
	 */
	JobInfo queryDepartByJobInfoIdService(Integer jobInfoId);
	
	/**
	 * 搜索
	 * @param keyWord
	 * @return List<JobInfo>
	 */
	List<JobInfo> searchJobInfoService(String keyWord);
	
}
