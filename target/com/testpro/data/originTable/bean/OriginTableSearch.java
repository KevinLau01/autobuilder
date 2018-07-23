package com.testpro.data.originTable.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:OriginTable
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("OriginTableSearch")
public class OriginTableSearch extends PageModel {
	
	private Integer	id;		
	private String	courseId;		 /* 课程id */ 
	private String	stuId;		 /* 学生id */ 
	private String	clientId;		 /* 客户端id */ 
	private Integer	type;		 /* 类型，1活跃度，2愉悦度 */ 
	private Integer	data;		 /* 对应数据 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		 /* 删除时间 */ 

	// Constructor
	public OriginTableSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public OriginTableSearch(Integer id, String courseId, String stuId, String clientId, Integer type, Integer data, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.courseId = courseId;
		this.stuId = stuId;
		this.clientId = clientId;
		this.type = type;
		this.data = data;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为OriginTable可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public OriginTableSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public OriginTableSearch setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public String getStuId() {
		return stuId;
	}

	public OriginTableSearch setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public String getClientId() {
		return clientId;
	}

	public OriginTableSearch setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public Integer getType() {
		return type;
	}

	public OriginTableSearch setType(Integer type) {
		this.type = type;
		return this;
	}
	
	public Integer getData() {
		return data;
	}

	public OriginTableSearch setData(Integer data) {
		this.data = data;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public OriginTableSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public OriginTableSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public OriginTableSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}