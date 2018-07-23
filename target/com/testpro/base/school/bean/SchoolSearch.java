package com.testpro.base.school.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:School
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("SchoolSearch")
public class SchoolSearch extends PageModel {
	
	private Integer	id;		
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
	public SchoolSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public SchoolSearch(Integer id, Integer organizationId, Integer cityId, String name, String address, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public SchoolSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public SchoolSearch setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	public Integer getCityId() {
		return cityId;
	}

	public SchoolSearch setCityId(Integer cityId) {
		this.cityId = cityId;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public SchoolSearch setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getAddress() {
		return address;
	}

	public SchoolSearch setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public SchoolSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public SchoolSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public SchoolSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public SchoolSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public SchoolSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}