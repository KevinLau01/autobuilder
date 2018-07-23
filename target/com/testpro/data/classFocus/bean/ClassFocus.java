package com.testpro.data.classFocus.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:ClassFocus
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("ClassFocus")
public class ClassFocus extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	organizationId;		 /* 机构id */ 
	private Integer	classId;		 /* 班级id */ 
	private Double	score;		 /* 分值 */ 
	private Date	createAt;		
	private Date	updateAt;		

	// Constructor
	public ClassFocus() {
	}
	
	/**
	 * full Constructor
	 */
	public ClassFocus(Integer id, Integer courseId, Integer organizationId, Integer classId, Double score, Date createAt, Date updateAt) {
		setId(id);
		this.courseId = courseId;
		this.organizationId = organizationId;
		this.classId = classId;
		this.score = score;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ClassFocus可以实现连缀设置属性
	
	public Integer getCourseId() {
		return courseId;
	}

	public ClassFocus setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public ClassFocus setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	
	public Integer getClassId() {
		return classId;
	}

	public ClassFocus setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	
	public Double getScore() {
		return score;
	}

	public ClassFocus setScore(Double score) {
		this.score = score;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateAt() {
		return createAt;
	}

	public ClassFocus setCreateAt(Date createAt) {
		this.createAt = createAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdateAt() {
		return updateAt;
	}

	public ClassFocus setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "ClassFocus [" + "id=" + getId() + ", courseId=" + courseId + ", organizationId=" + organizationId + ", classId=" + classId + ", score=" + score + ", createAt=" + createAt + ", updateAt=" + updateAt +  "]";
	}
}
