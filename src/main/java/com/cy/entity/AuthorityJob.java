package com.cy.entity;

/**
 * 职位与权限对应关系实体类
 * @author cy
 *
 */
public class AuthorityJob {

	private Integer authorityJobId;
	private Integer jobInfoId;
	private Integer authorityId;
	
	//一对一权限关系映射
	private Authority authority;
	
	public Integer getAuthorityJobId() {
		return authorityJobId;
	}
	public void setAuthorityJobId(Integer authorityJobId) {
		this.authorityJobId = authorityJobId;
	}
	public Integer getJobInfoId() {
		return jobInfoId;
	}
	public void setJobInfoId(Integer jobInfoId) {
		this.jobInfoId = jobInfoId;
	}
	public Integer getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}
	
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "AuthorityJob [authorityJobId=" + authorityJobId + ", jobInfoId=" + jobInfoId + ", authorityId="
				+ authorityId + "]";
	}
	
}
