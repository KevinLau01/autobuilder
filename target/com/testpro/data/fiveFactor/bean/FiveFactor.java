package com.testpro.data.fiveFactor.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:FiveFactor
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("FiveFactor")
public class FiveFactor extends BaseEntity {
	
	
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
	public FiveFactor() {
	}
	
	/**
	 * full Constructor
	 */
	public FiveFactor(Integer id, Integer courseId, Integer classId, Integer stuId, Integer focusScore, Integer activeScore, Integer pleasureScore, Integer masterScore, Integer lectureScore, Integer totalScore, Integer totalLevel, Integer totalChange, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
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
	
	public Integer getCourseId() {
		return courseId;
	}

	public FiveFactor setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getClassId() {
		return classId;
	}

	public FiveFactor setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	
	public Integer getStuId() {
		return stuId;
	}

	public FiveFactor setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public Integer getFocusScore() {
		return focusScore;
	}

	public FiveFactor setFocusScore(Integer focusScore) {
		this.focusScore = focusScore;
		return this;
	}
	
	
	public Integer getActiveScore() {
		return activeScore;
	}

	public FiveFactor setActiveScore(Integer activeScore) {
		this.activeScore = activeScore;
		return this;
	}
	
	
	public Integer getPleasureScore() {
		return pleasureScore;
	}

	public FiveFactor setPleasureScore(Integer pleasureScore) {
		this.pleasureScore = pleasureScore;
		return this;
	}
	
	
	public Integer getMasterScore() {
		return masterScore;
	}

	public FiveFactor setMasterScore(Integer masterScore) {
		this.masterScore = masterScore;
		return this;
	}
	
	
	public Integer getLectureScore() {
		return lectureScore;
	}

	public FiveFactor setLectureScore(Integer lectureScore) {
		this.lectureScore = lectureScore;
		return this;
	}
	
	
	public Integer getTotalScore() {
		return totalScore;
	}

	public FiveFactor setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
		return this;
	}
	
	
	public Integer getTotalLevel() {
		return totalLevel;
	}

	public FiveFactor setTotalLevel(Integer totalLevel) {
		this.totalLevel = totalLevel;
		return this;
	}
	
	
	public Integer getTotalChange() {
		return totalChange;
	}

	public FiveFactor setTotalChange(Integer totalChange) {
		this.totalChange = totalChange;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public FiveFactor setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public FiveFactor setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public FiveFactor setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "FiveFactor [" + "id=" + getId() + ", courseId=" + courseId + ", classId=" + classId + ", stuId=" + stuId + ", focusScore=" + focusScore + ", activeScore=" + activeScore + ", pleasureScore=" + pleasureScore + ", masterScore=" + masterScore + ", lectureScore=" + lectureScore + ", totalScore=" + totalScore + ", totalLevel=" + totalLevel + ", totalChange=" + totalChange + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
