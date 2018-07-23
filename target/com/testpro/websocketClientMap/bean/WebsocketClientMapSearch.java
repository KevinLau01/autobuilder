package com.testpro.websocketClientMap.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:WebsocketClientMap
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("WebsocketClientMapSearch")
public class WebsocketClientMapSearch extends PageModel {
	
	private Integer	id;		
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
	public WebsocketClientMapSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public WebsocketClientMapSearch(Integer id, String orgId, String courseId, String clientId, String socketId, String attribute, String session, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public WebsocketClientMapSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getOrgId() {
		return orgId;
	}

	public WebsocketClientMapSearch setOrgId(String orgId) {
		this.orgId = orgId;
		return this;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public WebsocketClientMapSearch setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public String getClientId() {
		return clientId;
	}

	public WebsocketClientMapSearch setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public String getSocketId() {
		return socketId;
	}

	public WebsocketClientMapSearch setSocketId(String socketId) {
		this.socketId = socketId;
		return this;
	}
	
	public String getAttribute() {
		return attribute;
	}

	public WebsocketClientMapSearch setAttribute(String attribute) {
		this.attribute = attribute;
		return this;
	}
	
	public String getSession() {
		return session;
	}

	public WebsocketClientMapSearch setSession(String session) {
		this.session = session;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public WebsocketClientMapSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public WebsocketClientMapSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public WebsocketClientMapSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}