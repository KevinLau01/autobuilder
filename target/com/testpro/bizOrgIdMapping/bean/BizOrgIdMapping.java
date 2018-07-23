package com.testpro.bizOrgIdMapping.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:BizOrgIdMapping
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("BizOrgIdMapping")
public class BizOrgIdMapping extends BaseEntity {
	
	
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
	public BizOrgIdMapping() {
	}
	
	/**
	 * full Constructor
	 */
	public BizOrgIdMapping(Integer id, Integer orgId, String model, Integer bizId, Integer sysId, String bizData, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		setId(id);
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
	
	public Integer getOrgId() {
		return orgId;
	}

	public BizOrgIdMapping setOrgId(Integer orgId) {
		this.orgId = orgId;
		return this;
	}
	
	
	public String getModel() {
		return model;
	}

	public BizOrgIdMapping setModel(String model) {
		this.model = model;
		return this;
	}
	
	
	public Integer getBizId() {
		return bizId;
	}

	public BizOrgIdMapping setBizId(Integer bizId) {
		this.bizId = bizId;
		return this;
	}
	
	
	public Integer getSysId() {
		return sysId;
	}

	public BizOrgIdMapping setSysId(Integer sysId) {
		this.sysId = sysId;
		return this;
	}
	
	
	public String getBizData() {
		return bizData;
	}

	public BizOrgIdMapping setBizData(String bizData) {
		this.bizData = bizData;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public BizOrgIdMapping setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public BizOrgIdMapping setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public BizOrgIdMapping setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public BizOrgIdMapping setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public BizOrgIdMapping setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "BizOrgIdMapping [" + "id=" + getId() + ", orgId=" + orgId + ", model=" + model + ", bizId=" + bizId + ", sysId=" + sysId + ", bizData=" + bizData + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser +  "]";
	}
}
