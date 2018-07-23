package com.testpro.base.organization.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:Organization
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("Organization")
public class Organization extends BaseEntity {
	
	
	private String	name;		 /* 机构名称 */ 
	private String	description;		 /* 描述 */ 
	private String	accessKey;		 /* access key */ 
	private String	securityKey;		 /* security key */ 
	private Integer	type;		 /* 机构类型 1公立校  2ToB */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public Organization() {
	}
	
	/**
	 * full Constructor
	 */
	public Organization(Integer id, String name, String description, String accessKey, String securityKey, Integer type, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		setId(id);
		this.name = name;
		this.description = description;
		this.accessKey = accessKey;
		this.securityKey = securityKey;
		this.type = type;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Organization可以实现连缀设置属性
	
	public String getName() {
		return name;
	}

	public Organization setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getDescription() {
		return description;
	}

	public Organization setDescription(String description) {
		this.description = description;
		return this;
	}
	
	
	public String getAccessKey() {
		return accessKey;
	}

	public Organization setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}
	
	
	public String getSecurityKey() {
		return securityKey;
	}

	public Organization setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
		return this;
	}
	
	
	public Integer getType() {
		return type;
	}

	public Organization setType(Integer type) {
		this.type = type;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public Organization setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public Organization setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public Organization setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public Organization setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public Organization setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "Organization [" + "id=" + getId() + ", name=" + name + ", description=" + description + ", accessKey=" + accessKey + ", securityKey=" + securityKey + ", type=" + type + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser +  "]";
	}
}
