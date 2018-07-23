package com.testpro.logOperation.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:LogOperation
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("LogOperationSearch")
public class LogOperationSearch extends PageModel {
	
	private Integer	id;		
	private String	orgName;		 /* 机构名称 */ 
	private String	schoolName;		 /* 学校名称 */ 
	private String	userName;		 /* 用户名称 */ 
	private String	email;		 /* 邮箱 */ 
	private String	roleName;		 /* 角色名称 */ 
	private String	model;		 /* 操作模块 */ 
	private String	operation;		 /* 操作方法 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	description;		 /* 操作内容 */ 

	// Constructor
	public LogOperationSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public LogOperationSearch(Integer id, String orgName, String schoolName, String userName, String email, String roleName, String model, String operation, Integer createdtime, String description) {
		this.id = id;
		this.orgName = orgName;
		this.schoolName = schoolName;
		this.userName = userName;
		this.email = email;
		this.roleName = roleName;
		this.model = model;
		this.operation = operation;
		this.createdtime = createdtime;
		this.description = description;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为LogOperation可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public LogOperationSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getOrgName() {
		return orgName;
	}

	public LogOperationSearch setOrgName(String orgName) {
		this.orgName = orgName;
		return this;
	}
	
	public String getSchoolName() {
		return schoolName;
	}

	public LogOperationSearch setSchoolName(String schoolName) {
		this.schoolName = schoolName;
		return this;
	}
	
	public String getUserName() {
		return userName;
	}

	public LogOperationSearch setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	
	public String getEmail() {
		return email;
	}

	public LogOperationSearch setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public LogOperationSearch setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
	
	public String getModel() {
		return model;
	}

	public LogOperationSearch setModel(String model) {
		this.model = model;
		return this;
	}
	
	public String getOperation() {
		return operation;
	}

	public LogOperationSearch setOperation(String operation) {
		this.operation = operation;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public LogOperationSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getDescription() {
		return description;
	}

	public LogOperationSearch setDescription(String description) {
		this.description = description;
		return this;
	}
	
}