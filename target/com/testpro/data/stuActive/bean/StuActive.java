package com.testpro.data.stuActive.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:StuActive
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("StuActive")
public class StuActive extends BaseEntity {
	
	
	private String	courseId;		 /* 课程id */ 
	private String	stuId;		 /* 学生id */ 
	private Integer	type;		 /* 类型，1活跃度，2愉悦度 */ 
	private Integer	times;		 /* 第几次数 */ 
	private Double	degree;		 /* 活跃度数据 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public StuActive() {
	}
	
	/**
	 * full Constructor
	 */
	public StuActive(Integer id, String courseId, String stuId, Integer type, Integer times, Double degree, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
		this.courseId = courseId;
		this.stuId = stuId;
		this.type = type;
		this.times = times;
		this.degree = degree;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuActive可以实现连缀设置属性
	
	public String getCourseId() {
		return courseId;
	}

	public StuActive setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getStuId() {
		return stuId;
	}

	public StuActive setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public Integer getType() {
		return type;
	}

	public StuActive setType(Integer type) {
		this.type = type;
		return this;
	}
	
	
	public Integer getTimes() {
		return times;
	}

	public StuActive setTimes(Integer times) {
		this.times = times;
		return this;
	}
	
	
	public Double getDegree() {
		return degree;
	}

	public StuActive setDegree(Double degree) {
		this.degree = degree;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public StuActive setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public StuActive setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public StuActive setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "StuActive [" + "id=" + getId() + ", courseId=" + courseId + ", stuId=" + stuId + ", type=" + type + ", times=" + times + ", degree=" + degree + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
