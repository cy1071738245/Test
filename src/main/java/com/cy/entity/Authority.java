package com.cy.entity;

/**
 * 权限实体类
 * @author cy
 *
 */
public class Authority {

	private Integer authorityId;
	private String authorityName;
	private Integer authorityType;
	private String urlCode;
	private Integer parentId;
	
	public Integer getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public Integer getAuthorityType() {
		return authorityType;
	}
	public void setAuthorityType(Integer authorityType) {
		this.authorityType = authorityType;
	}
	public String getUrlCode() {
		return urlCode;
	}
	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	@Override
	public String toString() {
		return "Authority [authorityId=" + authorityId + ", authorityName=" + authorityName + ", authorityType="
				+ authorityType + ", urlCode=" + urlCode + ", parentId=" + parentId + "]";
	}
	
}
