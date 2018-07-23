package com.testpro.base.school.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:School
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("School")
public class School extends BaseEntity {
	
	
	private Integer	organizationId;		 /* 机构id */ 
	private Integer	cityId;		 /* 城市id */ 
	private String	name;		 /* 学校名称 */ 
	private String	address;		 /* 学校地址 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public School() {
	}
	
	/**
	 * full Constructor
	 */
	public School(Integer id, Integer organizationId, Integer cityId, String name, String address, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		setId(id);
		this.organizationId = organizationId;
		this.cityId = cityId;
		this.name = name;
		this.address = address;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为School可以实现连缀设置属性
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public School setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	
	public Integer getCityId() {
		return cityId;
	}

	public School setCityId(Integer cityId) {
		this.cityId = cityId;
		return this;
	}
	
	
	public String getName() {
		return name;
	}

	public School setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getAddress() {
		return address;
	}

	public School setAddress(String address) {
		this.address = address;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public School setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public School setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public School setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public School setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public School setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "School [" + "id=" + getId() + ", organizationId=" + organizationId + ", cityId=" + cityId + ", name=" + name + ", address=" + address + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser +  "]";
	}
}
