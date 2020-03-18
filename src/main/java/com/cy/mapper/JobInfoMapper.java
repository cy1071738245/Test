package com.cy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cy.entity.JobInfo;

public interface JobInfoMapper {

	/**
	 * 查询所有职位
	 * @return List<JobInfo>
	 */
	List<JobInfo> allJobInfo();
	
	/**
	 * 检查职位名是否重复
	 * @param jobInfoName
	 * @return JobInfo
	 */
	JobInfo checkJobInfoName(@Param("jobInfoName")String jobInfoName);
	
	/**
	 * 修改职位信息
	 * @param jobInfo
	 * @return Integer
	 */
	Integer updateJobInfo(@Param("jobInfo")JobInfo jobInfo);
	
	/**
	 * 新增职位信息
	 * @param jobInfo
	 * @return Integer
	 */
	Integer insertJobInfo(@Param("jobInfo")JobInfo jobInfo);
	
	/**
	 * 删除职位信息
	 * @param jobInfo
	 * @return Integer
	 */
	Integer deleteJobInfo(@Param("jobInfo")JobInfo jobInfo);
	
	/**
	 * 根据职位id查询部门信息
	 * @param jobInfoId
	 * @return JobInfo
	 */
	JobInfo queryDepartByJobInfoId(@Param("jobInfoId")Integer jobInfoId);
	
	/**
	 * 搜索
	 * @param keyWord
	 * @return List<JobInfo>
	 */
	List<JobInfo> searchJobInfo(@Param("keyWord")String keyWord);
	
}
