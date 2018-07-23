package com.testpro.feedBack.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:FeedBack
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("FeedBackSearch")
public class FeedBackSearch extends PageModel {
	
	private Integer	id;		
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
	public FeedBackSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public FeedBackSearch(Integer id, String courseId, String classId, String stuId, String teacherId, String assistantId, String teacherLevel, String assistantLevel, String courseTime, String feedWord, Integer status, Integer mainScore, Integer assistScore, String dealFeed, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public FeedBackSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public FeedBackSearch setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public String getClassId() {
		return classId;
	}

	public FeedBackSearch setClassId(String classId) {
		this.classId = classId;
		return this;
	}
	
	public String getStuId() {
		return stuId;
	}

	public FeedBackSearch setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public String getTeacherId() {
		return teacherId;
	}

	public FeedBackSearch setTeacherId(String teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	public String getAssistantId() {
		return assistantId;
	}

	public FeedBackSearch setAssistantId(String assistantId) {
		this.assistantId = assistantId;
		return this;
	}
	
	public String getTeacherLevel() {
		return teacherLevel;
	}

	public FeedBackSearch setTeacherLevel(String teacherLevel) {
		this.teacherLevel = teacherLevel;
		return this;
	}
	
	public String getAssistantLevel() {
		return assistantLevel;
	}

	public FeedBackSearch setAssistantLevel(String assistantLevel) {
		this.assistantLevel = assistantLevel;
		return this;
	}
	
	public String getCourseTime() {
		return courseTime;
	}

	public FeedBackSearch setCourseTime(String courseTime) {
		this.courseTime = courseTime;
		return this;
	}
	
	public String getFeedWord() {
		return feedWord;
	}

	public FeedBackSearch setFeedWord(String feedWord) {
		this.feedWord = feedWord;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public FeedBackSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Integer getMainScore() {
		return mainScore;
	}

	public FeedBackSearch setMainScore(Integer mainScore) {
		this.mainScore = mainScore;
		return this;
	}
	
	public Integer getAssistScore() {
		return assistScore;
	}

	public FeedBackSearch setAssistScore(Integer assistScore) {
		this.assistScore = assistScore;
		return this;
	}
	
	public String getDealFeed() {
		return dealFeed;
	}

	public FeedBackSearch setDealFeed(String dealFeed) {
		this.dealFeed = dealFeed;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public FeedBackSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public FeedBackSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public FeedBackSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}