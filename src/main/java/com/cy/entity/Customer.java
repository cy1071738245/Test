package com.cy.entity;

/**
 * 客户实体类
 * @author cy
 *
 */
public class Customer
{

	private Integer customerId;
	private String customerName;
	private String education;
	private String customerPhone;
	private Integer qq;
	private String customerEmail;
	private Integer customerStatus;
	private String createDate;
	private String inviterName;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Integer getQq() {
		return qq;
	}
	public void setQq(Integer qq) {
		this.qq = qq;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Integer getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(Integer customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getInviterName() {
		return inviterName;
	}
	public void setInviterName(String inviterName) {
		this.inviterName = inviterName;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", education=" + education
				+ ", customerPhone=" + customerPhone + ", qq=" + qq + ", customerEmail=" + customerEmail
				+ ", customerStatus=" + customerStatus + ", createDate=" + createDate + ", inviterName=" + inviterName
				+ "]";
	}
}
