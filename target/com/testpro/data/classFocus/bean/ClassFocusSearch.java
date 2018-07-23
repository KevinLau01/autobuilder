package com.testpro.data.classFocus.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:ClassFocus
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ClassFocusSearch")
public class ClassFocusSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	organizationId;		 /* 机构id */ 
	private Integer	classId;		 /* 班级id */ 
	private Double	score;		 /* 分值 */ 
	private Date	createAt;		
	private Date	updateAt;		

	// Constructor
	public ClassFocusSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ClassFocusSearch(Integer id, Integer courseId, Integer organizationId, Integer classId, Double score, Date createAt, Date updateAt) {
		this.id = id;
		this.courseId = courseId;
		this.organizationId = organizationId;
		this.classId = classId;
		this.score = score;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ClassFocus可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ClassFocusSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public ClassFocusSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public ClassFocusSearch setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public ClassFocusSearch setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	public Double getScore() {
		return score;
	}

	public ClassFocusSearch setScore(Double score) {
		this.score = score;
		return this;
	}
	
	public Date getCreateAt() {
		return createAt;
	}

	public ClassFocusSearch setCreateAt(Date createAt) {
		this.createAt = createAt;
		return this;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}

	public ClassFocusSearch setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
		return this;
	}
	
}