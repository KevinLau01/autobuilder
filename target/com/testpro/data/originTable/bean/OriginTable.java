package com.testpro.data.originTable.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:OriginTable
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("OriginTable")
public class OriginTable extends BaseEntity {
	
	
	private String	courseId;		 /* 课程id */ 
	private String	stuId;		 /* 学生id */ 
	private String	clientId;		 /* 客户端id */ 
	private Integer	type;		 /* 类型，1活跃度，2愉悦度 */ 
	private Integer	data;		 /* 对应数据 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		 /* 删除时间 */ 

	// Constructor
	public OriginTable() {
	}
	
	/**
	 * full Constructor
	 */
	public OriginTable(Integer id, String courseId, String stuId, String clientId, Integer type, Integer data, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
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
	
	public String getCourseId() {
		return courseId;
	}

	public OriginTable setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getStuId() {
		return stuId;
	}

	public OriginTable setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public String getClientId() {
		return clientId;
	}

	public OriginTable setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	
	
	public Integer getType() {
		return type;
	}

	public OriginTable setType(Integer type) {
		this.type = type;
		return this;
	}
	
	
	public Integer getData() {
		return data;
	}

	public OriginTable setData(Integer data) {
		this.data = data;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public OriginTable setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public OriginTable setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public OriginTable setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "OriginTable [" + "id=" + getId() + ", courseId=" + courseId + ", stuId=" + stuId + ", clientId=" + clientId + ", type=" + type + ", data=" + data + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
