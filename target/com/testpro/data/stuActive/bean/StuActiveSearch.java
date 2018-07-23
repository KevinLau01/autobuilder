package com.testpro.data.stuActive.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:StuActive
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("StuActiveSearch")
public class StuActiveSearch extends PageModel {
	
	private Integer	id;		
	private String	courseId;		 /* 课程id */ 
	private String	stuId;		 /* 学生id */ 
	private Integer	type;		 /* 类型，1活跃度，2愉悦度 */ 
	private Integer	times;		 /* 第几次数 */ 
	private Double	degree;		 /* 活跃度数据 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public StuActiveSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public StuActiveSearch(Integer id, String courseId, String stuId, Integer type, Integer times, Double degree, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public StuActiveSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public StuActiveSearch setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public String getStuId() {
		return stuId;
	}

	public StuActiveSearch setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public Integer getType() {
		return type;
	}

	public StuActiveSearch setType(Integer type) {
		this.type = type;
		return this;
	}
	
	public Integer getTimes() {
		return times;
	}

	public StuActiveSearch setTimes(Integer times) {
		this.times = times;
		return this;
	}
	
	public Double getDegree() {
		return degree;
	}

	public StuActiveSearch setDegree(Double degree) {
		this.degree = degree;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public StuActiveSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public StuActiveSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public StuActiveSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}