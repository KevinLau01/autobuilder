package com.testpro.bizOrgIdMapping.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:BizOrgIdMapping
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("BizOrgIdMappingSearch")
public class BizOrgIdMappingSearch extends PageModel {
	
	private Integer	id;		
	private Integer	orgId;		 /* 机构id */ 
	private String	model;		 /* 模块code   例如学校模块、教室模块 */ 
	private Integer	bizId;		 /* 机构系统内的id */ 
	private Integer	sysId;		 /* 魔镜系统内的id */ 
	private String	bizData;		 /* 机构系统中，模块对应的值 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public BizOrgIdMappingSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public BizOrgIdMappingSearch(Integer id, Integer orgId, String model, Integer bizId, Integer sysId, String bizData, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
		this.orgId = orgId;
		this.model = model;
		this.bizId = bizId;
		this.sysId = sysId;
		this.bizData = bizData;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为BizOrgIdMapping可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public BizOrgIdMappingSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getOrgId() {
		return orgId;
	}

	public BizOrgIdMappingSearch setOrgId(Integer orgId) {
		this.orgId = orgId;
		return this;
	}
	
	public String getModel() {
		return model;
	}

	public BizOrgIdMappingSearch setModel(String model) {
		this.model = model;
		return this;
	}
	
	public Integer getBizId() {
		return bizId;
	}

	public BizOrgIdMappingSearch setBizId(Integer bizId) {
		this.bizId = bizId;
		return this;
	}
	
	public Integer getSysId() {
		return sysId;
	}

	public BizOrgIdMappingSearch setSysId(Integer sysId) {
		this.sysId = sysId;
		return this;
	}
	
	public String getBizData() {
		return bizData;
	}

	public BizOrgIdMappingSearch setBizData(String bizData) {
		this.bizData = bizData;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public BizOrgIdMappingSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public BizOrgIdMappingSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public BizOrgIdMappingSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public BizOrgIdMappingSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public BizOrgIdMappingSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}