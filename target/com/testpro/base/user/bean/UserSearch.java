package com.testpro.base.user.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:User
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("UserSearch")
public class UserSearch extends PageModel {
	
	private Integer	id;		
	private String	loginId;		 /* 登录账号-手机号 */ 
	private String	password;		 /* 密码 */ 
	private Integer	status;		 /* 状态 */ 
	private Integer	organizationId;		 /* 机构id */ 
	private String	email;		 /* 邮箱 */ 
	private String	name;		 /* 名称 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public UserSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public UserSearch(Integer id, String loginId, String password, Integer status, Integer organizationId, String email, String name, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.status = status;
		this.organizationId = organizationId;
		this.email = email;
		this.name = name;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为User可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public UserSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getLoginId() {
		return loginId;
	}

	public UserSearch setLoginId(String loginId) {
		this.loginId = loginId;
		return this;
	}
	
	public String getPassword() {
		return password;
	}

	public UserSearch setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public UserSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public UserSearch setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	public String getEmail() {
		return email;
	}

	public UserSearch setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public UserSearch setName(String name) {
		this.name = name;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public UserSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public UserSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public UserSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public UserSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public UserSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}