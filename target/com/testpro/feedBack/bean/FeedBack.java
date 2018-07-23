package com.testpro.feedBack.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:FeedBack
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("FeedBack")
public class FeedBack extends BaseEntity {
	
	
	private String	courseId;		 /* 课程id */ 
	private String	classId;		 /* 班级Id */ 
	private String	stuId;		 /* 反馈用户id */ 
	private String	teacherId;		 /* 教师Id */ 
	private String	assistantId;		 /* 助教id */ 
	private String	teacherLevel;		 /* 教师反馈等级 */ 
	private String	assistantLevel;		 /* 助教反馈等级 */ 
	private String	courseTime;		 /* 课次 */ 
	private String	feedWord;		 /* 反馈内容 */ 
	private Integer	status;		 /* 发布状态 */ 
	private Integer	mainScore;		
	private Integer	assistScore;		
	private String	dealFeed;		 /* 处理反馈 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public FeedBack() {
	}
	
	/**
	 * full Constructor
	 */
	public FeedBack(Integer id, String courseId, String classId, String stuId, String teacherId, String assistantId, String teacherLevel, String assistantLevel, String courseTime, String feedWord, Integer status, Integer mainScore, Integer assistScore, String dealFeed, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
		this.courseId = courseId;
		this.classId = classId;
		this.stuId = stuId;
		this.teacherId = teacherId;
		this.assistantId = assistantId;
		this.teacherLevel = teacherLevel;
		this.assistantLevel = assistantLevel;
		this.courseTime = courseTime;
		this.feedWord = feedWord;
		this.status = status;
		this.mainScore = mainScore;
		this.assistScore = assistScore;
		this.dealFeed = dealFeed;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为FeedBack可以实现连缀设置属性
	
	public String getCourseId() {
		return courseId;
	}

	public FeedBack setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getClassId() {
		return classId;
	}

	public FeedBack setClassId(String classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getStuId() {
		return stuId;
	}

	public FeedBack setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public String getTeacherId() {
		return teacherId;
	}

	public FeedBack setTeacherId(String teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	
	public String getAssistantId() {
		return assistantId;
	}

	public FeedBack setAssistantId(String assistantId) {
		this.assistantId = assistantId;
		return this;
	}
	
	
	public String getTeacherLevel() {
		return teacherLevel;
	}

	public FeedBack setTeacherLevel(String teacherLevel) {
		this.teacherLevel = teacherLevel;
		return this;
	}
	
	
	public String getAssistantLevel() {
		return assistantLevel;
	}

	public FeedBack setAssistantLevel(String assistantLevel) {
		this.assistantLevel = assistantLevel;
		return this;
	}
	
	
	public String getCourseTime() {
		return courseTime;
	}

	public FeedBack setCourseTime(String courseTime) {
		this.courseTime = courseTime;
		return this;
	}
	
	
	public String getFeedWord() {
		return feedWord;
	}

	public FeedBack setFeedWord(String feedWord) {
		this.feedWord = feedWord;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public FeedBack setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	
	public Integer getMainScore() {
		return mainScore;
	}

	public FeedBack setMainScore(Integer mainScore) {
		this.mainScore = mainScore;
		return this;
	}
	
	
	public Integer getAssistScore() {
		return assistScore;
	}

	public FeedBack setAssistScore(Integer assistScore) {
		this.assistScore = assistScore;
		return this;
	}
	
	
	public String getDealFeed() {
		return dealFeed;
	}

	public FeedBack setDealFeed(String dealFeed) {
		this.dealFeed = dealFeed;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public FeedBack setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public FeedBack setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public FeedBack setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "FeedBack [" + "id=" + getId() + ", courseId=" + courseId + ", classId=" + classId + ", stuId=" + stuId + ", teacherId=" + teacherId + ", assistantId=" + assistantId + ", teacherLevel=" + teacherLevel + ", assistantLevel=" + assistantLevel + ", courseTime=" + courseTime + ", feedWord=" + feedWord + ", status=" + status + ", mainScore=" + mainScore + ", assistScore=" + assistScore + ", dealFeed=" + dealFeed + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
