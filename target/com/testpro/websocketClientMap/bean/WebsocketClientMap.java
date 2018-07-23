package com.testpro.websocketClientMap.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:WebsocketClientMap
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("WebsocketClientMap")
public class WebsocketClientMap extends BaseEntity {
	
	
	private String	orgId;		 /* 机构id */ 
	private String	courseId;		 /* 班级课程id */ 
	private String	clientId;		 /* 客户端id */ 
	private String	socketId;		 /* socket id */ 
	private String	attribute;		 /* socket 属性 */ 
	private String	session;		 /* session字符串 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		 /* 删除时间 */ 

	// Constructor
	public WebsocketClientMap() {
	}
	
	/**
	 * full Constructor
	 */
	public WebsocketClientMap(Integer id, String orgId, String courseId, String clientId, String socketId, String attribute, String session, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
		this.orgId = orgId;
		this.courseId = courseId;
		this.clientId = clientId;
		this.socketId = socketId;
		this.attribute = attribute;
		this.session = session;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为WebsocketClientMap可以实现连缀设置属性
	
	public String getOrgId() {
		return orgId;
	}

	public WebsocketClientMap setOrgId(String orgId) {
		this.orgId = orgId;
		return this;
	}
	
	
	public String getCourseId() {
		return courseId;
	}

	public WebsocketClientMap setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getClientId() {
		return clientId;
	}

	public WebsocketClientMap setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	
	
	public String getSocketId() {
		return socketId;
	}

	public WebsocketClientMap setSocketId(String socketId) {
		this.socketId = socketId;
		return this;
	}
	
	
	public String getAttribute() {
		return attribute;
	}

	public WebsocketClientMap setAttribute(String attribute) {
		this.attribute = attribute;
		return this;
	}
	
	
	public String getSession() {
		return session;
	}

	public WebsocketClientMap setSession(String session) {
		this.session = session;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public WebsocketClientMap setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public WebsocketClientMap setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public WebsocketClientMap setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "WebsocketClientMap [" + "id=" + getId() + ", orgId=" + orgId + ", courseId=" + courseId + ", clientId=" + clientId + ", socketId=" + socketId + ", attribute=" + attribute + ", session=" + session + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
