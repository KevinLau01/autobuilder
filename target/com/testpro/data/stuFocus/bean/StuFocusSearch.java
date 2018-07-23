package com.testpro.data.stuFocus.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:StuFocus
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("StuFocusSearch")
public class StuFocusSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	organizationId;		 /* 机构id */ 
	private Integer	stuId;		 /* 学生id(识别序列号，假id) */ 
	private Double	score;		 /* 分值 */ 
	private Date	createAt;		
	private Date	updateAt;		

	// Constructor
	public StuFocusSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public StuFocusSearch(Integer id, Integer courseId, Integer organizationId, Integer stuId, Double score, Date createAt, Date updateAt) {
		this.id = id;
		this.courseId = courseId;
		this.organizationId = organizationId;
		this.stuId = stuId;
		this.score = score;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuFocus可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public StuFocusSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuFocusSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public StuFocusSearch setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	public Integer getStuId() {
		return stuId;
	}

	public StuFocusSearch setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public Double getScore() {
		return score;
	}

	public StuFocusSearch setScore(Double score) {
		this.score = score;
		return this;
	}
	
	public Date getCreateAt() {
		return createAt;
	}

	public StuFocusSearch setCreateAt(Date createAt) {
		this.createAt = createAt;
		return this;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}

	public StuFocusSearch setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
		return this;
	}
	
}