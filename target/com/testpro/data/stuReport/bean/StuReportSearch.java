package com.testpro.data.stuReport.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:StuReport
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("StuReportSearch")
public class StuReportSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private String	courseName;		 /* 课程名称 */ 
	private Integer	organizationId;		 /* 组织id */ 
	private Integer	schoolId;		 /* 学校id */ 
	private Integer	classId;		 /* 班级id */ 
	private String	className;		 /* 班级名字 */ 
	private Integer	skuId;		 /* 学科id */ 
	private String	skuName;		 /* 学科 */ 
	private Integer	stuId;		 /* 学生id (id化之前为客户端识别id) */ 
	private String	stuName;		 /* 学生名字 */ 
	private Integer	totalTime;		 /* 课程时间长度(去除下课时间) */ 
	private Double	focusAvg;		 /* 专注度平均值 */ 
	private Integer	focusRanking;		 /* 专注度排名 */ 
	private Integer	focusChange;		 /* 专注度相比上次，提高是1，下降是-1.不变是0 */ 
	private String	focusCurve;		 /* 专注度曲线 */ 
	private String	focusDownIndex;		 /* 专注度下降点的index */ 
	private Integer	focusScore;		 /* 专注度分数 */ 
	private Integer	focusLevel;		
	private String	focusImgUrl;		 /* 专注度图片(被标记过的) */ 
	private String	focusVideoImgUrl;		 /* 专注瞬间视频预览图 */ 
	private String	focusVideoUrl;		 /* 专注瞬间视频 */ 
	private Double	activeAvg;		 /* 活跃度平均值 */ 
	private Integer	activeRanking;		 /* 活跃度排名 */ 
	private Integer	activeChange;		 /* 活跃度相比上次，提高是1，下降是-1.不变是0 */ 
	private String	activeImgUrl;		 /* 活跃度图片(被标记过的) */ 
	private String	activeVideoImgUrl;		 /* 活跃瞬间视频预览图 */ 
	private String	activeVideoUrl;		 /* 活跃瞬间视频 */ 
	private String	activeCurve;		 /* 活跃度曲线 */ 
	private Integer	activeScore;		 /* 活跃度分数 */ 
	private Integer	activeHandsUp;		
	private Integer	activeLevel;		
	private String	pleasureImgUrl;		 /* 愉悦的度图片 */ 
	private String	pleasureVideoImgUrl;		 /* 愉悦的视频预览图 */ 
	private String	pleasureVideoUrl;		 /* 愉悦的视频url */ 
	private String	pleasureCurve;		 /* 愉悦度曲线 */ 
	private Integer	pleasureScore;		 /* 愉悦度分数 */ 
	private Integer	pleasureChange;		
	private Integer	pleasureLevel;		
	private String	masterCurve;		 /* 掌握度曲线 */ 
	private String	masterCurvePre;		
	private Integer	masterScore;		 /* 掌握度分数 */ 
	private Integer	masterChange;		
	private Integer	masterLevel;		
	private String	lectureCurve;		 /* 听课度曲线 */ 
	private String	lectureCurvePre;		
	private Integer	lectureChange;		 /* 听课度想不上节课改变 */ 
	private Integer	lectureLevel;		 /* 听课度级别 */ 
	private Integer	lectureScore;		
	private Integer	parrentFeedbackId;		 /* 家长反馈记录id */ 
	private Integer	isDone;		 /* 报告是否已完成 */ 
	private Integer	isRead;		 /* 报告是否已读 */ 
	private Integer	tagStep;		 /* 报告标注执行到第几步 */ 
	private Integer	handlePeopleId;		 /* 标注报告操作人id */ 
	private String	handlePeopleName;		 /* 标注报告操作人名字 */ 
	private Date	handleTime;		 /* 上次报告标注时间 */ 
	private Date	createAt;		
	private Date	updateAt;		
	private String	status;		 /* 标注 */ 

	// Constructor
	public StuReportSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public StuReportSearch(Integer id, Integer courseId, String courseName, Integer organizationId, Integer schoolId, Integer classId, String className, Integer skuId, String skuName, Integer stuId, String stuName, Integer totalTime, Double focusAvg, Integer focusRanking, Integer focusChange, String focusCurve, String focusDownIndex, Integer focusScore, Integer focusLevel, String focusImgUrl, String focusVideoImgUrl, String focusVideoUrl, Double activeAvg, Integer activeRanking, Integer activeChange, String activeImgUrl, String activeVideoImgUrl, String activeVideoUrl, String activeCurve, Integer activeScore, Integer activeHandsUp, Integer activeLevel, String pleasureImgUrl, String pleasureVideoImgUrl, String pleasureVideoUrl, String pleasureCurve, Integer pleasureScore, Integer pleasureChange, Integer pleasureLevel, String masterCurve, String masterCurvePre, Integer masterScore, Integer masterChange, Integer masterLevel, String lectureCurve, String lectureCurvePre, Integer lectureChange, Integer lectureLevel, Integer lectureScore, Integer parrentFeedbackId, Integer isDone, Integer isRead, Integer tagStep, Integer handlePeopleId, String handlePeopleName, Date handleTime, Date createAt, Date updateAt, String status) {
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.organizationId = organizationId;
		this.schoolId = schoolId;
		this.classId = classId;
		this.className = className;
		this.skuId = skuId;
		this.skuName = skuName;
		this.stuId = stuId;
		this.stuName = stuName;
		this.totalTime = totalTime;
		this.focusAvg = focusAvg;
		this.focusRanking = focusRanking;
		this.focusChange = focusChange;
		this.focusCurve = focusCurve;
		this.focusDownIndex = focusDownIndex;
		this.focusScore = focusScore;
		this.focusLevel = focusLevel;
		this.focusImgUrl = focusImgUrl;
		this.focusVideoImgUrl = focusVideoImgUrl;
		this.focusVideoUrl = focusVideoUrl;
		this.activeAvg = activeAvg;
		this.activeRanking = activeRanking;
		this.activeChange = activeChange;
		this.activeImgUrl = activeImgUrl;
		this.activeVideoImgUrl = activeVideoImgUrl;
		this.activeVideoUrl = activeVideoUrl;
		this.activeCurve = activeCurve;
		this.activeScore = activeScore;
		this.activeHandsUp = activeHandsUp;
		this.activeLevel = activeLevel;
		this.pleasureImgUrl = pleasureImgUrl;
		this.pleasureVideoImgUrl = pleasureVideoImgUrl;
		this.pleasureVideoUrl = pleasureVideoUrl;
		this.pleasureCurve = pleasureCurve;
		this.pleasureScore = pleasureScore;
		this.pleasureChange = pleasureChange;
		this.pleasureLevel = pleasureLevel;
		this.masterCurve = masterCurve;
		this.masterCurvePre = masterCurvePre;
		this.masterScore = masterScore;
		this.masterChange = masterChange;
		this.masterLevel = masterLevel;
		this.lectureCurve = lectureCurve;
		this.lectureCurvePre = lectureCurvePre;
		this.lectureChange = lectureChange;
		this.lectureLevel = lectureLevel;
		this.lectureScore = lectureScore;
		this.parrentFeedbackId = parrentFeedbackId;
		this.isDone = isDone;
		this.isRead = isRead;
		this.tagStep = tagStep;
		this.handlePeopleId = handlePeopleId;
		this.handlePeopleName = handlePeopleName;
		this.handleTime = handleTime;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.status = status;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuReport可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public StuReportSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuReportSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public StuReportSearch setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public StuReportSearch setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public StuReportSearch setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public StuReportSearch setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	public String getClassName() {
		return className;
	}

	public StuReportSearch setClassName(String className) {
		this.className = className;
		return this;
	}
	
	public Integer getSkuId() {
		return skuId;
	}

	public StuReportSearch setSkuId(Integer skuId) {
		this.skuId = skuId;
		return this;
	}
	
	public String getSkuName() {
		return skuName;
	}

	public StuReportSearch setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}
	
	public Integer getStuId() {
		return stuId;
	}

	public StuReportSearch setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public String getStuName() {
		return stuName;
	}

	public StuReportSearch setStuName(String stuName) {
		this.stuName = stuName;
		return this;
	}
	
	public Integer getTotalTime() {
		return totalTime;
	}

	public StuReportSearch setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
		return this;
	}
	
	public Double getFocusAvg() {
		return focusAvg;
	}

	public StuReportSearch setFocusAvg(Double focusAvg) {
		this.focusAvg = focusAvg;
		return this;
	}
	
	public Integer getFocusRanking() {
		return focusRanking;
	}

	public StuReportSearch setFocusRanking(Integer focusRanking) {
		this.focusRanking = focusRanking;
		return this;
	}
	
	public Integer getFocusChange() {
		return focusChange;
	}

	public StuReportSearch setFocusChange(Integer focusChange) {
		this.focusChange = focusChange;
		return this;
	}
	
	public String getFocusCurve() {
		return focusCurve;
	}

	public StuReportSearch setFocusCurve(String focusCurve) {
		this.focusCurve = focusCurve;
		return this;
	}
	
	public String getFocusDownIndex() {
		return focusDownIndex;
	}

	public StuReportSearch setFocusDownIndex(String focusDownIndex) {
		this.focusDownIndex = focusDownIndex;
		return this;
	}
	
	public Integer getFocusScore() {
		return focusScore;
	}

	public StuReportSearch setFocusScore(Integer focusScore) {
		this.focusScore = focusScore;
		return this;
	}
	
	public Integer getFocusLevel() {
		return focusLevel;
	}

	public StuReportSearch setFocusLevel(Integer focusLevel) {
		this.focusLevel = focusLevel;
		return this;
	}
	
	public String getFocusImgUrl() {
		return focusImgUrl;
	}

	public StuReportSearch setFocusImgUrl(String focusImgUrl) {
		this.focusImgUrl = focusImgUrl;
		return this;
	}
	
	public String getFocusVideoImgUrl() {
		return focusVideoImgUrl;
	}

	public StuReportSearch setFocusVideoImgUrl(String focusVideoImgUrl) {
		this.focusVideoImgUrl = focusVideoImgUrl;
		return this;
	}
	
	public String getFocusVideoUrl() {
		return focusVideoUrl;
	}

	public StuReportSearch setFocusVideoUrl(String focusVideoUrl) {
		this.focusVideoUrl = focusVideoUrl;
		return this;
	}
	
	public Double getActiveAvg() {
		return activeAvg;
	}

	public StuReportSearch setActiveAvg(Double activeAvg) {
		this.activeAvg = activeAvg;
		return this;
	}
	
	public Integer getActiveRanking() {
		return activeRanking;
	}

	public StuReportSearch setActiveRanking(Integer activeRanking) {
		this.activeRanking = activeRanking;
		return this;
	}
	
	public Integer getActiveChange() {
		return activeChange;
	}

	public StuReportSearch setActiveChange(Integer activeChange) {
		this.activeChange = activeChange;
		return this;
	}
	
	public String getActiveImgUrl() {
		return activeImgUrl;
	}

	public StuReportSearch setActiveImgUrl(String activeImgUrl) {
		this.activeImgUrl = activeImgUrl;
		return this;
	}
	
	public String getActiveVideoImgUrl() {
		return activeVideoImgUrl;
	}

	public StuReportSearch setActiveVideoImgUrl(String activeVideoImgUrl) {
		this.activeVideoImgUrl = activeVideoImgUrl;
		return this;
	}
	
	public String getActiveVideoUrl() {
		return activeVideoUrl;
	}

	public StuReportSearch setActiveVideoUrl(String activeVideoUrl) {
		this.activeVideoUrl = activeVideoUrl;
		return this;
	}
	
	public String getActiveCurve() {
		return activeCurve;
	}

	public StuReportSearch setActiveCurve(String activeCurve) {
		this.activeCurve = activeCurve;
		return this;
	}
	
	public Integer getActiveScore() {
		return activeScore;
	}

	public StuReportSearch setActiveScore(Integer activeScore) {
		this.activeScore = activeScore;
		return this;
	}
	
	public Integer getActiveHandsUp() {
		return activeHandsUp;
	}

	public StuReportSearch setActiveHandsUp(Integer activeHandsUp) {
		this.activeHandsUp = activeHandsUp;
		return this;
	}
	
	public Integer getActiveLevel() {
		return activeLevel;
	}

	public StuReportSearch setActiveLevel(Integer activeLevel) {
		this.activeLevel = activeLevel;
		return this;
	}
	
	public String getPleasureImgUrl() {
		return pleasureImgUrl;
	}

	public StuReportSearch setPleasureImgUrl(String pleasureImgUrl) {
		this.pleasureImgUrl = pleasureImgUrl;
		return this;
	}
	
	public String getPleasureVideoImgUrl() {
		return pleasureVideoImgUrl;
	}

	public StuReportSearch setPleasureVideoImgUrl(String pleasureVideoImgUrl) {
		this.pleasureVideoImgUrl = pleasureVideoImgUrl;
		return this;
	}
	
	public String getPleasureVideoUrl() {
		return pleasureVideoUrl;
	}

	public StuReportSearch setPleasureVideoUrl(String pleasureVideoUrl) {
		this.pleasureVideoUrl = pleasureVideoUrl;
		return this;
	}
	
	public String getPleasureCurve() {
		return pleasureCurve;
	}

	public StuReportSearch setPleasureCurve(String pleasureCurve) {
		this.pleasureCurve = pleasureCurve;
		return this;
	}
	
	public Integer getPleasureScore() {
		return pleasureScore;
	}

	public StuReportSearch setPleasureScore(Integer pleasureScore) {
		this.pleasureScore = pleasureScore;
		return this;
	}
	
	public Integer getPleasureChange() {
		return pleasureChange;
	}

	public StuReportSearch setPleasureChange(Integer pleasureChange) {
		this.pleasureChange = pleasureChange;
		return this;
	}
	
	public Integer getPleasureLevel() {
		return pleasureLevel;
	}

	public StuReportSearch setPleasureLevel(Integer pleasureLevel) {
		this.pleasureLevel = pleasureLevel;
		return this;
	}
	
	public String getMasterCurve() {
		return masterCurve;
	}

	public StuReportSearch setMasterCurve(String masterCurve) {
		this.masterCurve = masterCurve;
		return this;
	}
	
	public String getMasterCurvePre() {
		return masterCurvePre;
	}

	public StuReportSearch setMasterCurvePre(String masterCurvePre) {
		this.masterCurvePre = masterCurvePre;
		return this;
	}
	
	public Integer getMasterScore() {
		return masterScore;
	}

	public StuReportSearch setMasterScore(Integer masterScore) {
		this.masterScore = masterScore;
		return this;
	}
	
	public Integer getMasterChange() {
		return masterChange;
	}

	public StuReportSearch setMasterChange(Integer masterChange) {
		this.masterChange = masterChange;
		return this;
	}
	
	public Integer getMasterLevel() {
		return masterLevel;
	}

	public StuReportSearch setMasterLevel(Integer masterLevel) {
		this.masterLevel = masterLevel;
		return this;
	}
	
	public String getLectureCurve() {
		return lectureCurve;
	}

	public StuReportSearch setLectureCurve(String lectureCurve) {
		this.lectureCurve = lectureCurve;
		return this;
	}
	
	public String getLectureCurvePre() {
		return lectureCurvePre;
	}

	public StuReportSearch setLectureCurvePre(String lectureCurvePre) {
		this.lectureCurvePre = lectureCurvePre;
		return this;
	}
	
	public Integer getLectureChange() {
		return lectureChange;
	}

	public StuReportSearch setLectureChange(Integer lectureChange) {
		this.lectureChange = lectureChange;
		return this;
	}
	
	public Integer getLectureLevel() {
		return lectureLevel;
	}

	public StuReportSearch setLectureLevel(Integer lectureLevel) {
		this.lectureLevel = lectureLevel;
		return this;
	}
	
	public Integer getLectureScore() {
		return lectureScore;
	}

	public StuReportSearch setLectureScore(Integer lectureScore) {
		this.lectureScore = lectureScore;
		return this;
	}
	
	public Integer getParrentFeedbackId() {
		return parrentFeedbackId;
	}

	public StuReportSearch setParrentFeedbackId(Integer parrentFeedbackId) {
		this.parrentFeedbackId = parrentFeedbackId;
		return this;
	}
	
	public Integer getIsDone() {
		return isDone;
	}

	public StuReportSearch setIsDone(Integer isDone) {
		this.isDone = isDone;
		return this;
	}
	
	public Integer getIsRead() {
		return isRead;
	}

	public StuReportSearch setIsRead(Integer isRead) {
		this.isRead = isRead;
		return this;
	}
	
	public Integer getTagStep() {
		return tagStep;
	}

	public StuReportSearch setTagStep(Integer tagStep) {
		this.tagStep = tagStep;
		return this;
	}
	
	public Integer getHandlePeopleId() {
		return handlePeopleId;
	}

	public StuReportSearch setHandlePeopleId(Integer handlePeopleId) {
		this.handlePeopleId = handlePeopleId;
		return this;
	}
	
	public String getHandlePeopleName() {
		return handlePeopleName;
	}

	public StuReportSearch setHandlePeopleName(String handlePeopleName) {
		this.handlePeopleName = handlePeopleName;
		return this;
	}
	
	public Date getHandleTime() {
		return handleTime;
	}

	public StuReportSearch setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
		return this;
	}
	
	public Date getCreateAt() {
		return createAt;
	}

	public StuReportSearch setCreateAt(Date createAt) {
		this.createAt = createAt;
		return this;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}

	public StuReportSearch setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
		return this;
	}
	
	public String getStatus() {
		return status;
	}

	public StuReportSearch setStatus(String status) {
		this.status = status;
		return this;
	}
	
}