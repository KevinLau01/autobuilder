package com.testpro.teacherRecommentFactor.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:TeacherRecommentFactor
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("TeacherRecommentFactor")
public class TeacherRecommentFactor extends BaseEntity {
	
	
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
	public TeacherRecommentFactor() {
	}
	
	/**
	 * full Constructor
	 */
	public TeacherRecommentFactor(Integer id, Integer classId, Integer courseId, Integer stuId, String focusScore, String activeScore, String happyScore, String masterScore, String attendScore, Date createdAt, Date updatedAt, Date deletedAt, String updateuser, Integer status, Integer teacherId, String teacherName) {
		setId(id);
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
	
	public Integer getClassId() {
		return classId;
	}

	public TeacherRecommentFactor setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	
	public Integer getCourseId() {
		return courseId;
	}

	public TeacherRecommentFactor setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getStuId() {
		return stuId;
	}

	public TeacherRecommentFactor setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public String getFocusScore() {
		return focusScore;
	}

	public TeacherRecommentFactor setFocusScore(String focusScore) {
		this.focusScore = focusScore;
		return this;
	}
	
	
	public String getActiveScore() {
		return activeScore;
	}

	public TeacherRecommentFactor setActiveScore(String activeScore) {
		this.activeScore = activeScore;
		return this;
	}
	
	
	public String getHappyScore() {
		return happyScore;
	}

	public TeacherRecommentFactor setHappyScore(String happyScore) {
		this.happyScore = happyScore;
		return this;
	}
	
	
	public String getMasterScore() {
		return masterScore;
	}

	public TeacherRecommentFactor setMasterScore(String masterScore) {
		this.masterScore = masterScore;
		return this;
	}
	
	
	public String getAttendScore() {
		return attendScore;
	}

	public TeacherRecommentFactor setAttendScore(String attendScore) {
		this.attendScore = attendScore;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public TeacherRecommentFactor setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public TeacherRecommentFactor setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public TeacherRecommentFactor setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	
	public String getUpdateuser() {
		return updateuser;
	}

	public TeacherRecommentFactor setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public TeacherRecommentFactor setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public TeacherRecommentFactor setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	
	public String getTeacherName() {
		return teacherName;
	}

	public TeacherRecommentFactor setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		return this;
	}
	
	@Override
	public String toString() {
		return "TeacherRecommentFactor [" + "id=" + getId() + ", classId=" + classId + ", courseId=" + courseId + ", stuId=" + stuId + ", focusScore=" + focusScore + ", activeScore=" + activeScore + ", happyScore=" + happyScore + ", masterScore=" + masterScore + ", attendScore=" + attendScore + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", updateuser=" + updateuser + ", status=" + status + ", teacherId=" + teacherId + ", teacherName=" + teacherName +  "]";
	}
}
