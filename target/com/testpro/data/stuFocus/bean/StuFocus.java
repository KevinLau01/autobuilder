package com.testpro.data.stuFocus.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:StuFocus
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("StuFocus")
public class StuFocus extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	organizationId;		 /* 机构id */ 
	private Integer	stuId;		 /* 学生id(识别序列号，假id) */ 
	private Double	score;		 /* 分值 */ 
	private Date	createAt;		
	private Date	updateAt;		

	// Constructor
	public StuFocus() {
	}
	
	/**
	 * full Constructor
	 */
	public StuFocus(Integer id, Integer courseId, Integer organizationId, Integer stuId, Double score, Date createAt, Date updateAt) {
		setId(id);
		this.courseId = courseId;
		this.organizationId = organizationId;
		this.stuId = stuId;
		this.score = score;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuFocus可以实现连缀设置属性
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuFocus setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public StuFocus setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	
	public Integer getStuId() {
		return stuId;
	}

	public StuFocus setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public Double getScore() {
		return score;
	}

	public StuFocus setScore(Double score) {
		this.score = score;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateAt() {
		return createAt;
	}

	public StuFocus setCreateAt(Date createAt) {
		this.createAt = createAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdateAt() {
		return updateAt;
	}

	public StuFocus setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "StuFocus [" + "id=" + getId() + ", courseId=" + courseId + ", organizationId=" + organizationId + ", stuId=" + stuId + ", score=" + score + ", createAt=" + createAt + ", updateAt=" + updateAt +  "]";
	}
}
