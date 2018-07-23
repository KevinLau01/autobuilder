package com.testpro.data.stuDaily.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:StuDaily
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("StuDaily")
public class StuDaily extends BaseEntity {
	
	
	private String	classId;		 /* 班级id */ 
	private String	className;		 /* 班级名称 */ 
	private String	courseTime;		 /* 课次 */ 
	private Integer	status;		 /* 发布状态 */ 
	private String	courseId;		 /* 学科id */ 
	private String	courseName;		 /* 学科名称 */ 
	private String	pushLanguage;		 /* 推送语 */ 
	private String	pushAnswer;		 /* 推送答案 */ 
	private String	pushTitle;		 /* 推送标题 */ 
	private String	pushType;		 /* 推送类型 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	createUser;		 /* 创建人 */ 
	private String	updateUser;		 /* 修改人 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private String	teacherId;		 /* 教师id */ 
	private String	teacherName;		 /* 教师名称 */ 
	private String	assistantName;		 /* 辅导老师 */ 
	private String	assistantId;		 /* 辅导老师id */ 

	// Constructor
	public StuDaily() {
	}
	
	/**
	 * full Constructor
	 */
	public StuDaily(Integer id, String classId, String className, String courseTime, Integer status, String courseId, String courseName, String pushLanguage, String pushAnswer, String pushTitle, String pushType, Integer createdtime, Integer updatetime, String createUser, String updateUser, Integer deleted, String teacherId, String teacherName, String assistantName, String assistantId) {
		setId(id);
		this.classId = classId;
		this.className = className;
		this.courseTime = courseTime;
		this.status = status;
		this.courseId = courseId;
		this.courseName = courseName;
		this.pushLanguage = pushLanguage;
		this.pushAnswer = pushAnswer;
		this.pushTitle = pushTitle;
		this.pushType = pushType;
		this.createdtime = createdtime;
		this.updatetime = updatetime;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.deleted = deleted;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.assistantName = assistantName;
		this.assistantId = assistantId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuDaily可以实现连缀设置属性
	
	public String getClassId() {
		return classId;
	}

	public StuDaily setClassId(String classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getClassName() {
		return className;
	}

	public StuDaily setClassName(String className) {
		this.className = className;
		return this;
	}
	
	
	public String getCourseTime() {
		return courseTime;
	}

	public StuDaily setCourseTime(String courseTime) {
		this.courseTime = courseTime;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public StuDaily setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	
	public String getCourseId() {
		return courseId;
	}

	public StuDaily setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getCourseName() {
		return courseName;
	}

	public StuDaily setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	
	
	public String getPushLanguage() {
		return pushLanguage;
	}

	public StuDaily setPushLanguage(String pushLanguage) {
		this.pushLanguage = pushLanguage;
		return this;
	}
	
	
	public String getPushAnswer() {
		return pushAnswer;
	}

	public StuDaily setPushAnswer(String pushAnswer) {
		this.pushAnswer = pushAnswer;
		return this;
	}
	
	
	public String getPushTitle() {
		return pushTitle;
	}

	public StuDaily setPushTitle(String pushTitle) {
		this.pushTitle = pushTitle;
		return this;
	}
	
	
	public String getPushType() {
		return pushType;
	}

	public StuDaily setPushType(String pushType) {
		this.pushType = pushType;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public StuDaily setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public StuDaily setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getCreateUser() {
		return createUser;
	}

	public StuDaily setCreateUser(String createUser) {
		this.createUser = createUser;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public StuDaily setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public StuDaily setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public String getTeacherId() {
		return teacherId;
	}

	public StuDaily setTeacherId(String teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	
	public String getTeacherName() {
		return teacherName;
	}

	public StuDaily setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		return this;
	}
	
	
	public String getAssistantName() {
		return assistantName;
	}

	public StuDaily setAssistantName(String assistantName) {
		this.assistantName = assistantName;
		return this;
	}
	
	
	public String getAssistantId() {
		return assistantId;
	}

	public StuDaily setAssistantId(String assistantId) {
		this.assistantId = assistantId;
		return this;
	}
	
	@Override
	public String toString() {
		return "StuDaily [" + "id=" + getId() + ", classId=" + classId + ", className=" + className + ", courseTime=" + courseTime + ", status=" + status + ", courseId=" + courseId + ", courseName=" + courseName + ", pushLanguage=" + pushLanguage + ", pushAnswer=" + pushAnswer + ", pushTitle=" + pushTitle + ", pushType=" + pushType + ", createdtime=" + createdtime + ", updatetime=" + updatetime + ", createUser=" + createUser + ", updateUser=" + updateUser + ", deleted=" + deleted + ", teacherId=" + teacherId + ", teacherName=" + teacherName + ", assistantName=" + assistantName + ", assistantId=" + assistantId +  "]";
	}
}
