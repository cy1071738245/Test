package com.cy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.entity.JobInfo;
import com.cy.mapper.JobInfoMapper;
import com.cy.service.JobInfoService;

@Service("jobInfoService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class JobInfoServiceImpl implements JobInfoService {

	@Resource(name="jobInfoMapper")
	private JobInfoMapper jobInfoMapper;
	
	/**
	 * 查询所有职位
	 */
	@Override
	public List<JobInfo> allJobInfoService() {
		
		List<JobInfo> result = jobInfoMapper.allJobInfo();
		
		return result;
	}

	/**
	 * 检查职位名是否重复
	 */
	@Override
	public JobInfo checkJobInfoName(String jobInfoName) {

		JobInfo result= jobInfoMapper.checkJobInfoName(jobInfoName);
		
		return result;
	}

	/**
	 * 变更职位信息
	 */
	@Override
	public Integer operateRoleService(JobInfo jobInfo) {
		
		Integer result = 0;
		
		if(jobInfo.getJobInfoId() != null && jobInfo.getDepartmentId() != null) {
			result = jobInfoMapper.updateJobInfo(jobInfo);
		}else if(jobInfo.getJobInfoId() != null && jobInfo.getDepartmentId() == null){
			
			//如果删除的是超级管理员则不予删除
			if(jobInfo.getJobInfoId() == 1) {
				return -2;
			}
			
			result = jobInfoMapper.deleteJobInfo(jobInfo);
		}else {
			result = jobInfoMapper.insertJobInfo(jobInfo);
		}
		
		return result;
	}

	/**
	 * 根据职位id查询部门信息
	 */
	@Override
	public JobInfo queryDepartByJobInfoIdService(Integer jobInfoId) {

		JobInfo result = jobInfoMapper.queryDepartByJobInfoId(jobInfoId);
		
		return result;
	}

	/**
	 * 搜索
	 */
	@Override
	public List<JobInfo> searchJobInfoService(String keyWord) {

		List<JobInfo> result = jobInfoMapper.searchJobInfo(keyWord);
		
		return result;
	}

}
