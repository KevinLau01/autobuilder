package com.testpro.base.course.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:Course
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("CourseSearch")
public class CourseSearch extends PageModel {
	
	private Integer	id;		
	private String	courseName;		 /* 课程名称 */ 
	private Integer	classId;		 /* 班级id */ 
	private String	className;		 /* 班级名称，冗余字段 */ 
	private Integer	classroomId;		 /* 教室id */ 
	private String	classroomName;		 /* 教室名字，冗余字段 */ 
	private Integer	courseDate;		 /* 课程日期 例如2018-06-12 */ 
	private Integer	week;		 /* 星期几 例如1、2、3 */ 
	private Integer	startTime;		 /* 课程开始时间 例如2018-06-12 12:00:00 */ 
	private Integer	endTime;		 /* 课程结束时间 例如2018-06-12 13:00:00 */ 
	private String	teacherId;		 /* 主讲老师id */ 
	private String	teacherName;		 /* 主讲老师名称，冗余字段 */ 
	private String	remark;		 /* 备注 */ 
	private Integer	skuId;		 /* 学科id */ 
	private String	skuName;		 /* 学科名字，冗余字段 */ 
	private Integer	assistantId;		 /* 助教老师id */ 
	private String	assistantName;		 /* 助教老师名称，冗余字段 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public CourseSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public CourseSearch(Integer id, String courseName, Integer classId, String className, Integer classroomId, String classroomName, Integer courseDate, Integer week, Integer startTime, Integer endTime, String teacherId, String teacherName, String remark, Integer skuId, String skuName, Integer assistantId, String assistantName, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
		this.courseName = courseName;
		this.classId = classId;
		this.className = className;
		this.classroomId = classroomId;
		this.classroomName = classroomName;
		this.courseDate = courseDate;
		this.week = week;
		this.startTime = startTime;
		this.endTime = endTime;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.remark = remark;
		this.skuId = skuId;
		this.skuName = skuName;
		this.assistantId = assistantId;
		this.assistantName = assistantName;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Course可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public CourseSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public CourseSearch setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public CourseSearch setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	public String getClassName() {
		return className;
	}

	public CourseSearch setClassName(String className) {
		this.className = className;
		return this;
	}
	
	public Integer getClassroomId() {
		return classroomId;
	}

	public CourseSearch setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
		return this;
	}
	
	public String getClassroomName() {
		return classroomName;
	}

	public CourseSearch setClassroomName(String classroomName) {
		this.classroomName = classroomName;
		return this;
	}
	
	public Integer getCourseDate() {
		return courseDate;
	}

	public CourseSearch setCourseDate(Integer courseDate) {
		this.courseDate = courseDate;
		return this;
	}
	
	public Integer getWeek() {
		return week;
	}

	public CourseSearch setWeek(Integer week) {
		this.week = week;
		return this;
	}
	
	public Integer getStartTime() {
		return startTime;
	}

	public CourseSearch setStartTime(Integer startTime) {
		this.startTime = startTime;
		return this;
	}
	
	public Integer getEndTime() {
		return endTime;
	}

	public CourseSearch setEndTime(Integer endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public String getTeacherId() {
		return teacherId;
	}

	public CourseSearch setTeacherId(String teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	public String getTeacherName() {
		return teacherName;
	}

	public CourseSearch setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		return this;
	}
	
	public String getRemark() {
		return remark;
	}

	public CourseSearch setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	
	public Integer getSkuId() {
		return skuId;
	}

	public CourseSearch setSkuId(Integer skuId) {
		this.skuId = skuId;
		return this;
	}
	
	public String getSkuName() {
		return skuName;
	}

	public CourseSearch setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}
	
	public Integer getAssistantId() {
		return assistantId;
	}

	public CourseSearch setAssistantId(Integer assistantId) {
		this.assistantId = assistantId;
		return this;
	}
	
	public String getAssistantName() {
		return assistantName;
	}

	public CourseSearch setAssistantName(String assistantName) {
		this.assistantName = assistantName;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public CourseSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public CourseSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public CourseSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public CourseSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public CourseSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}