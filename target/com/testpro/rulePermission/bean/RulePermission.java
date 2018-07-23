package com.testpro.rulePermission.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:RulePermission
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("RulePermission")
public class RulePermission extends BaseEntity {
	
	
	private String	name;		 /* 权限名称 */ 
	private String	router;		 /* router */ 
	private String	url;		 /* url */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public RulePermission() {
	}
	
	/**
	 * full Constructor
	 */
	public RulePermission(Integer id, String name, String router, String url, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		setId(id);
		this.name = name;
		this.router = router;
		this.url = url;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RulePermission可以实现连缀设置属性
	
	public String getName() {
		return name;
	}

	public RulePermission setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getRouter() {
		return router;
	}

	public RulePermission setRouter(String router) {
		this.router = router;
		return this;
	}
	
	
	public String getUrl() {
		return url;
	}

	public RulePermission setUrl(String url) {
		this.url = url;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public RulePermission setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public RulePermission setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public RulePermission setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public RulePermission setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public RulePermission setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "RulePermission [" + "id=" + getId() + ", name=" + name + ", router=" + router + ", url=" + url + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser +  "]";
	}
}
