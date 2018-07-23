package com.testpro.base.client.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:Client
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ClientSearch")
public class ClientSearch extends PageModel {
	
	private Integer	id;		
	private Integer	classroomId;		 /* 教室id */ 
	private String	clientVersion;		 /* 客户端版本 */ 
	private String	clientGuid;		 /* 客户端code，唯一标识 */ 
	private Integer	isblock;		 /* 是否锁定 */ 
	private Integer	status;		 /* 状态 */ 
	private String	remark;		 /* 备注 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public ClientSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ClientSearch(Integer id, Integer classroomId, String clientVersion, String clientGuid, Integer isblock, Integer status, String remark, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
		this.classroomId = classroomId;
		this.clientVersion = clientVersion;
		this.clientGuid = clientGuid;
		this.isblock = isblock;
		this.status = status;
		this.remark = remark;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Client可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ClientSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getClassroomId() {
		return classroomId;
	}

	public ClientSearch setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
		return this;
	}
	
	public String getClientVersion() {
		return clientVersion;
	}

	public ClientSearch setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
		return this;
	}
	
	public String getClientGuid() {
		return clientGuid;
	}

	public ClientSearch setClientGuid(String clientGuid) {
		this.clientGuid = clientGuid;
		return this;
	}
	
	public Integer getIsblock() {
		return isblock;
	}

	public ClientSearch setIsblock(Integer isblock) {
		this.isblock = isblock;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ClientSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public String getRemark() {
		return remark;
	}

	public ClientSearch setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public ClientSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public ClientSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public ClientSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public ClientSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public ClientSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}