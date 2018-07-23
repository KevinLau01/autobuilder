package com.testpro.teacherRecommentFactor.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:TeacherRecommentFactor
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("TeacherRecommentFactorSearch")
public class TeacherRecommentFactorSearch extends PageModel {
	
	private Integer	id;		
	private Integer	classId;		 /* 班级id */ 
	private Integer	courseId;		 /* 课程id */ 
	private Integer	stuId;		 /* 学生id */ 
	private String	focusScore;		 /* 专注度分数 */ 
	private String	activeScore;		 /* 活跃度分数 */ 
	private String	happyScore;		 /* 愉悦度分数 */ 
	private String	masterScore;		 /* 掌握度分数 */ 
	private String	attendScore;		 /* 听课度分数 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		
	private String	updateuser;		 /* 操作人 */ 
	private Integer	status;		 /* 点评状态 */ 
	private Integer	teacherId;		 /* 老师id */ 
	private String	teacherName;		 /* 老师姓名（冗余字段） */ 

	// Constructor
	public TeacherRecommentFactorSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public TeacherRecommentFactorSearch(Integer id, Integer classId, Integer courseId, Integer stuId, String focusScore, String activeScore, String happyScore, String masterScore, String attendScore, Date createdAt, Date updatedAt, Date deletedAt, String updateuser, Integer status, Integer teacherId, String teacherName) {
		this.id = id;
		this.classId = classId;
		this.courseId = courseId;
		this.stuId = stuId;
		this.focusScore = focusScore;
		this.activeScore = activeScore;
		this.happyScore = happyScore;
		this.masterScore = masterScore;
		this.attendScore = attendScore;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.updateuser = updateuser;
		this.status = status;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为TeacherRecommentFactor可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public TeacherRecommentFactorSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public TeacherRecommentFactorSearch setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public TeacherRecommentFactorSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getStuId() {
		return stuId;
	}

	public TeacherRecommentFactorSearch setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public String getFocusScore() {
		return focusScore;
	}

	public TeacherRecommentFactorSearch setFocusScore(String focusScore) {
		this.focusScore = focusScore;
		return this;
	}
	
	public String getActiveScore() {
		return activeScore;
	}

	public TeacherRecommentFactorSearch setActiveScore(String activeScore) {
		this.activeScore = activeScore;
		return this;
	}
	
	public String getHappyScore() {
		return happyScore;
	}

	public TeacherRecommentFactorSearch setHappyScore(String happyScore) {
		this.happyScore = happyScore;
		return this;
	}
	
	public String getMasterScore() {
		return masterScore;
	}

	public TeacherRecommentFactorSearch setMasterScore(String masterScore) {
		this.masterScore = masterScore;
		return this;
	}
	
	public String getAttendScore() {
		return attendScore;
	}

	public TeacherRecommentFactorSearch setAttendScore(String attendScore) {
		this.attendScore = attendScore;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public TeacherRecommentFactorSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public TeacherRecommentFactorSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public TeacherRecommentFactorSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	public String getUpdateuser() {
		return updateuser;
	}

	public TeacherRecommentFactorSearch setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public TeacherRecommentFactorSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public TeacherRecommentFactorSearch setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	public String getTeacherName() {
		return teacherName;
	}

	public TeacherRecommentFactorSearch setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		return this;
	}
	
}