package com.testpro.data.fiveFactor.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:FiveFactor
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("FiveFactorSearch")
public class FiveFactorSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		
	private Integer	classId;		 /* 班级id */ 
	private Integer	stuId;		 /* 学生id */ 
	private Integer	focusScore;		 /* 专注度分数 */ 
	private Integer	activeScore;		 /* 活跃度分数 */ 
	private Integer	pleasureScore;		 /* 愉悦度分数 */ 
	private Integer	masterScore;		 /* 掌握度分数 */ 
	private Integer	lectureScore;		 /* 听课度分数 */ 
	private Integer	totalScore;		
	private Integer	totalLevel;		
	private Integer	totalChange;		
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public FiveFactorSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public FiveFactorSearch(Integer id, Integer courseId, Integer classId, Integer stuId, Integer focusScore, Integer activeScore, Integer pleasureScore, Integer masterScore, Integer lectureScore, Integer totalScore, Integer totalLevel, Integer totalChange, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.courseId = courseId;
		this.classId = classId;
		this.stuId = stuId;
		this.focusScore = focusScore;
		this.activeScore = activeScore;
		this.pleasureScore = pleasureScore;
		this.masterScore = masterScore;
		this.lectureScore = lectureScore;
		this.totalScore = totalScore;
		this.totalLevel = totalLevel;
		this.totalChange = totalChange;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为FiveFactor可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public FiveFactorSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public FiveFactorSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public FiveFactorSearch setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	public Integer getStuId() {
		return stuId;
	}

	public FiveFactorSearch setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public Integer getFocusScore() {
		return focusScore;
	}

	public FiveFactorSearch setFocusScore(Integer focusScore) {
		this.focusScore = focusScore;
		return this;
	}
	
	public Integer getActiveScore() {
		return activeScore;
	}

	public FiveFactorSearch setActiveScore(Integer activeScore) {
		this.activeScore = activeScore;
		return this;
	}
	
	public Integer getPleasureScore() {
		return pleasureScore;
	}

	public FiveFactorSearch setPleasureScore(Integer pleasureScore) {
		this.pleasureScore = pleasureScore;
		return this;
	}
	
	public Integer getMasterScore() {
		return masterScore;
	}

	public FiveFactorSearch setMasterScore(Integer masterScore) {
		this.masterScore = masterScore;
		return this;
	}
	
	public Integer getLectureScore() {
		return lectureScore;
	}

	public FiveFactorSearch setLectureScore(Integer lectureScore) {
		this.lectureScore = lectureScore;
		return this;
	}
	
	public Integer getTotalScore() {
		return totalScore;
	}

	public FiveFactorSearch setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
		return this;
	}
	
	public Integer getTotalLevel() {
		return totalLevel;
	}

	public FiveFactorSearch setTotalLevel(Integer totalLevel) {
		this.totalLevel = totalLevel;
		return this;
	}
	
	public Integer getTotalChange() {
		return totalChange;
	}

	public FiveFactorSearch setTotalChange(Integer totalChange) {
		this.totalChange = totalChange;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public FiveFactorSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public FiveFactorSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public FiveFactorSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}