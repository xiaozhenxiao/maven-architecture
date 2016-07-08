package com.hanyun.platform.member.api.domain;

import java.util.Date;


public class BrandMember {
	private Long id;
	/** 品牌编号 **/
	private String brandId;
	/** 用户编号 **/
	private String userId;
	/** 会员卡号 **/
	private String memberId;
	/** 会员类型 **/
	private String typeId;
	/** 会员级别 **/
	private String level;
	/** 会员级别 **/
	private int status;
	/** 会员有效期 **/
	private String expiry;
	/** 总共消费金额 **/
	private int totalPrice;
	/** 服务次数/消费次数 **/
	private int serviceCount;
	/** 最后一次服务/消费时间 **/
	private Date lastServiceTime;
	/** 平均多少天消费/服务 **/
	private String serviceAvgDay;
	private String sourceStoreId;
	private String sourceStoreName;
	private Date createTime;
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getServiceCount() {
		return serviceCount;
	}
	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
	}
	public Date getLastServiceTime() {
		return lastServiceTime;
	}
	public void setLastServiceTime(Date lastServiceTime) {
		this.lastServiceTime = lastServiceTime;
	}
	public String getServiceAvgDay() {
		return serviceAvgDay;
	}
	public void setServiceAvgDay(String serviceAvgDay) {
		this.serviceAvgDay = serviceAvgDay;
	}
	public String getSourceStoreId() {
		return sourceStoreId;
	}
	public void setSourceStoreId(String sourceStoreId) {
		this.sourceStoreId = sourceStoreId;
	}
	public String getSourceStoreName() {
		return sourceStoreName;
	}
	public void setSourceStoreName(String sourceStoreName) {
		this.sourceStoreName = sourceStoreName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
