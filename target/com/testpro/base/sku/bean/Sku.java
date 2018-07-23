package com.testpro.base.sku.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:Sku
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("Sku")
public class Sku extends BaseEntity {
	
	
	private String	name;		 /* sku 学科名称 */ 
	private Integer	baseSchoolId;		 /* 学校id */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public Sku() {
	}
	
	/**
	 * full Constructor
	 */
	public Sku(Integer id, String name, Integer baseSchoolId, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		setId(id);
		this.name = name;
		this.baseSchoolId = baseSchoolId;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Sku可以实现连缀设置属性
	
	public String getName() {
		return name;
	}

	public Sku setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Integer getBaseSchoolId() {
		return baseSchoolId;
	}

	public Sku setBaseSchoolId(Integer baseSchoolId) {
		this.baseSchoolId = baseSchoolId;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public Sku setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public Sku setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public Sku setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public Sku setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public Sku setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "Sku [" + "id=" + getId() + ", name=" + name + ", baseSchoolId=" + baseSchoolId + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser +  "]";
	}
}
