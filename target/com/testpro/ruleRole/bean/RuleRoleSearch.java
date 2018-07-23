package com.testpro.ruleRole.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:RuleRole
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("RuleRoleSearch")
public class RuleRoleSearch extends PageModel {
	
	private Integer	id;		
	private Integer	type;		 /* 角色类型 1超级管理员 2普通管理员 */ 
	private String	name;		 /* 角色名称 */ 
	private String	code;		 /* 角色code，目前前端使用code进行判断 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public RuleRoleSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public RuleRoleSearch(Integer id, Integer type, String name, String code, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.code = code;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RuleRole可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public RuleRoleSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getType() {
		return type;
	}

	public RuleRoleSearch setType(Integer type) {
		this.type = type;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public RuleRoleSearch setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getCode() {
		return code;
	}

	public RuleRoleSearch setCode(String code) {
		this.code = code;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public RuleRoleSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public RuleRoleSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public RuleRoleSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public RuleRoleSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public RuleRoleSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}