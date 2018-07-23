package com.testpro.feedImpress.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:FeedImpress
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("FeedImpress")
public class FeedImpress extends BaseEntity {
	
	
	private String	courseId;		 /* 课程id */ 
	private String	classId;		
	private String	courseName;		 /* 学科名字 */ 
	private String	className;		 /* 课次名字 */ 
	private String	userId;		 /* 用户id */ 
	private String	teacherId;		 /* 教师ID */ 
	private String	teacherName;		 /* 教师名字 */ 
	private String	teacherType;		 /* 用户类型，1主讲老师，2辅导老师 */ 
	private String	assistantId;		 /* 辅导教师id */ 
	private String	assistantName;		 /* 辅导教师名字 */ 
	private String	courseTime;		 /* 课次 */ 
	private Integer	mainScore;		 /* 主讲分数 */ 
	private Integer	assistScore;		 /* 辅导分数 */ 
	private String	feedLevel;		 /* 反馈印象等级，1不满意，2一般般，3太赞啦 */ 
	private String	feedImpress;		 /* 家长反馈 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public FeedImpress() {
	}
	
	/**
	 * full Constructor
	 */
	public FeedImpress(Integer id, String courseId, String classId, String courseName, String className, String userId, String teacherId, String teacherName, String teacherType, String assistantId, String assistantName, String courseTime, Integer mainScore, Integer assistScore, String feedLevel, String feedImpress, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
		this.courseId = courseId;
		this.classId = classId;
		this.courseName = courseName;
		this.className = className;
		this.userId = userId;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherType = teacherType;
		this.assistantId = assistantId;
		this.assistantName = assistantName;
		this.courseTime = courseTime;
		this.mainScore = mainScore;
		this.assistScore = assistScore;
		this.feedLevel = feedLevel;
		this.feedImpress = feedImpress;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为FeedImpress可以实现连缀设置属性
	
	public String getCourseId() {
		return courseId;
	}

	public FeedImpress setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getClassId() {
		return classId;
	}

	public FeedImpress setClassId(String classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getCourseName() {
		return courseName;
	}

	public FeedImpress setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	
	
	public String getClassName() {
		return className;
	}

	public FeedImpress setClassName(String className) {
		this.className = className;
		return this;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public FeedImpress setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	public String getTeacherId() {
		return teacherId;
	}

	public FeedImpress setTeacherId(String teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	
	public String getTeacherName() {
		return teacherName;
	}

	public FeedImpress setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		return this;
	}
	
	
	public String getTeacherType() {
		return teacherType;
	}

	public FeedImpress setTeacherType(String teacherType) {
		this.teacherType = teacherType;
		return this;
	}
	
	
	public String getAssistantId() {
		return assistantId;
	}

	public FeedImpress setAssistantId(String assistantId) {
		this.assistantId = assistantId;
		return this;
	}
	
	
	public String getAssistantName() {
		return assistantName;
	}

	public FeedImpress setAssistantName(String assistantName) {
		this.assistantName = assistantName;
		return this;
	}
	
	
	public String getCourseTime() {
		return courseTime;
	}

	public FeedImpress setCourseTime(String courseTime) {
		this.courseTime = courseTime;
		return this;
	}
	
	
	public Integer getMainScore() {
		return mainScore;
	}

	public FeedImpress setMainScore(Integer mainScore) {
		this.mainScore = mainScore;
		return this;
	}
	
	
	public Integer getAssistScore() {
		return assistScore;
	}

	public FeedImpress setAssistScore(Integer assistScore) {
		this.assistScore = assistScore;
		return this;
	}
	
	
	public String getFeedLevel() {
		return feedLevel;
	}

	public FeedImpress setFeedLevel(String feedLevel) {
		this.feedLevel = feedLevel;
		return this;
	}
	
	
	public String getFeedImpress() {
		return feedImpress;
	}

	public FeedImpress setFeedImpress(String feedImpress) {
		this.feedImpress = feedImpress;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public FeedImpress setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public FeedImpress setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public FeedImpress setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "FeedImpress [" + "id=" + getId() + ", courseId=" + courseId + ", classId=" + classId + ", courseName=" + courseName + ", className=" + className + ", userId=" + userId + ", teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherType=" + teacherType + ", assistantId=" + assistantId + ", assistantName=" + assistantName + ", courseTime=" + courseTime + ", mainScore=" + mainScore + ", assistScore=" + assistScore + ", feedLevel=" + feedLevel + ", feedImpress=" + feedImpress + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
