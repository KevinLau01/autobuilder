package com.testpro.data.stuReport.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:StuReport
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("StuReport")
public class StuReport extends BaseEntity {
	
	
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
	public StuReport() {
	}
	
	/**
	 * full Constructor
	 */
	public StuReport(Integer id, Integer courseId, String courseName, Integer organizationId, Integer schoolId, Integer classId, String className, Integer skuId, String skuName, Integer stuId, String stuName, Integer totalTime, Double focusAvg, Integer focusRanking, Integer focusChange, String focusCurve, String focusDownIndex, Integer focusScore, Integer focusLevel, String focusImgUrl, String focusVideoImgUrl, String focusVideoUrl, Double activeAvg, Integer activeRanking, Integer activeChange, String activeImgUrl, String activeVideoImgUrl, String activeVideoUrl, String activeCurve, Integer activeScore, Integer activeHandsUp, Integer activeLevel, String pleasureImgUrl, String pleasureVideoImgUrl, String pleasureVideoUrl, String pleasureCurve, Integer pleasureScore, Integer pleasureChange, Integer pleasureLevel, String masterCurve, String masterCurvePre, Integer masterScore, Integer masterChange, Integer masterLevel, String lectureCurve, String lectureCurvePre, Integer lectureChange, Integer lectureLevel, Integer lectureScore, Integer parrentFeedbackId, Integer isDone, Integer isRead, Integer tagStep, Integer handlePeopleId, String handlePeopleName, Date handleTime, Date createAt, Date updateAt, String status) {
		setId(id);
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
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuReport setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getCourseName() {
		return courseName;
	}

	public StuReport setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public StuReport setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public StuReport setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	
	public Integer getClassId() {
		return classId;
	}

	public StuReport setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getClassName() {
		return className;
	}

	public StuReport setClassName(String className) {
		this.className = className;
		return this;
	}
	
	
	public Integer getSkuId() {
		return skuId;
	}

	public StuReport setSkuId(Integer skuId) {
		this.skuId = skuId;
		return this;
	}
	
	
	public String getSkuName() {
		return skuName;
	}

	public StuReport setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}
	
	
	public Integer getStuId() {
		return stuId;
	}

	public StuReport setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public String getStuName() {
		return stuName;
	}

	public StuReport setStuName(String stuName) {
		this.stuName = stuName;
		return this;
	}
	
	
	public Integer getTotalTime() {
		return totalTime;
	}

	public StuReport setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
		return this;
	}
	
	
	public Double getFocusAvg() {
		return focusAvg;
	}

	public StuReport setFocusAvg(Double focusAvg) {
		this.focusAvg = focusAvg;
		return this;
	}
	
	
	public Integer getFocusRanking() {
		return focusRanking;
	}

	public StuReport setFocusRanking(Integer focusRanking) {
		this.focusRanking = focusRanking;
		return this;
	}
	
	
	public Integer getFocusChange() {
		return focusChange;
	}

	public StuReport setFocusChange(Integer focusChange) {
		this.focusChange = focusChange;
		return this;
	}
	
	
	public String getFocusCurve() {
		return focusCurve;
	}

	public StuReport setFocusCurve(String focusCurve) {
		this.focusCurve = focusCurve;
		return this;
	}
	
	
	public String getFocusDownIndex() {
		return focusDownIndex;
	}

	public StuReport setFocusDownIndex(String focusDownIndex) {
		this.focusDownIndex = focusDownIndex;
		return this;
	}
	
	
	public Integer getFocusScore() {
		return focusScore;
	}

	public StuReport setFocusScore(Integer focusScore) {
		this.focusScore = focusScore;
		return this;
	}
	
	
	public Integer getFocusLevel() {
		return focusLevel;
	}

	public StuReport setFocusLevel(Integer focusLevel) {
		this.focusLevel = focusLevel;
		return this;
	}
	
	
	public String getFocusImgUrl() {
		return focusImgUrl;
	}

	public StuReport setFocusImgUrl(String focusImgUrl) {
		this.focusImgUrl = focusImgUrl;
		return this;
	}
	
	
	public String getFocusVideoImgUrl() {
		return focusVideoImgUrl;
	}

	public StuReport setFocusVideoImgUrl(String focusVideoImgUrl) {
		this.focusVideoImgUrl = focusVideoImgUrl;
		return this;
	}
	
	
	public String getFocusVideoUrl() {
		return focusVideoUrl;
	}

	public StuReport setFocusVideoUrl(String focusVideoUrl) {
		this.focusVideoUrl = focusVideoUrl;
		return this;
	}
	
	
	public Double getActiveAvg() {
		return activeAvg;
	}

	public StuReport setActiveAvg(Double activeAvg) {
		this.activeAvg = activeAvg;
		return this;
	}
	
	
	public Integer getActiveRanking() {
		return activeRanking;
	}

	public StuReport setActiveRanking(Integer activeRanking) {
		this.activeRanking = activeRanking;
		return this;
	}
	
	
	public Integer getActiveChange() {
		return activeChange;
	}

	public StuReport setActiveChange(Integer activeChange) {
		this.activeChange = activeChange;
		return this;
	}
	
	
	public String getActiveImgUrl() {
		return activeImgUrl;
	}

	public StuReport setActiveImgUrl(String activeImgUrl) {
		this.activeImgUrl = activeImgUrl;
		return this;
	}
	
	
	public String getActiveVideoImgUrl() {
		return activeVideoImgUrl;
	}

	public StuReport setActiveVideoImgUrl(String activeVideoImgUrl) {
		this.activeVideoImgUrl = activeVideoImgUrl;
		return this;
	}
	
	
	public String getActiveVideoUrl() {
		return activeVideoUrl;
	}

	public StuReport setActiveVideoUrl(String activeVideoUrl) {
		this.activeVideoUrl = activeVideoUrl;
		return this;
	}
	
	
	public String getActiveCurve() {
		return activeCurve;
	}

	public StuReport setActiveCurve(String activeCurve) {
		this.activeCurve = activeCurve;
		return this;
	}
	
	
	public Integer getActiveScore() {
		return activeScore;
	}

	public StuReport setActiveScore(Integer activeScore) {
		this.activeScore = activeScore;
		return this;
	}
	
	
	public Integer getActiveHandsUp() {
		return activeHandsUp;
	}

	public StuReport setActiveHandsUp(Integer activeHandsUp) {
		this.activeHandsUp = activeHandsUp;
		return this;
	}
	
	
	public Integer getActiveLevel() {
		return activeLevel;
	}

	public StuReport setActiveLevel(Integer activeLevel) {
		this.activeLevel = activeLevel;
		return this;
	}
	
	
	public String getPleasureImgUrl() {
		return pleasureImgUrl;
	}

	public StuReport setPleasureImgUrl(String pleasureImgUrl) {
		this.pleasureImgUrl = pleasureImgUrl;
		return this;
	}
	
	
	public String getPleasureVideoImgUrl() {
		return pleasureVideoImgUrl;
	}

	public StuReport setPleasureVideoImgUrl(String pleasureVideoImgUrl) {
		this.pleasureVideoImgUrl = pleasureVideoImgUrl;
		return this;
	}
	
	
	public String getPleasureVideoUrl() {
		return pleasureVideoUrl;
	}

	public StuReport setPleasureVideoUrl(String pleasureVideoUrl) {
		this.pleasureVideoUrl = pleasureVideoUrl;
		return this;
	}
	
	
	public String getPleasureCurve() {
		return pleasureCurve;
	}

	public StuReport setPleasureCurve(String pleasureCurve) {
		this.pleasureCurve = pleasureCurve;
		return this;
	}
	
	
	public Integer getPleasureScore() {
		return pleasureScore;
	}

	public StuReport setPleasureScore(Integer pleasureScore) {
		this.pleasureScore = pleasureScore;
		return this;
	}
	
	
	public Integer getPleasureChange() {
		return pleasureChange;
	}

	public StuReport setPleasureChange(Integer pleasureChange) {
		this.pleasureChange = pleasureChange;
		return this;
	}
	
	
	public Integer getPleasureLevel() {
		return pleasureLevel;
	}

	public StuReport setPleasureLevel(Integer pleasureLevel) {
		this.pleasureLevel = pleasureLevel;
		return this;
	}
	
	
	public String getMasterCurve() {
		return masterCurve;
	}

	public StuReport setMasterCurve(String masterCurve) {
		this.masterCurve = masterCurve;
		return this;
	}
	
	
	public String getMasterCurvePre() {
		return masterCurvePre;
	}

	public StuReport setMasterCurvePre(String masterCurvePre) {
		this.masterCurvePre = masterCurvePre;
		return this;
	}
	
	
	public Integer getMasterScore() {
		return masterScore;
	}

	public StuReport setMasterScore(Integer masterScore) {
		this.masterScore = masterScore;
		return this;
	}
	
	
	public Integer getMasterChange() {
		return masterChange;
	}

	public StuReport setMasterChange(Integer masterChange) {
		this.masterChange = masterChange;
		return this;
	}
	
	
	public Integer getMasterLevel() {
		return masterLevel;
	}

	public StuReport setMasterLevel(Integer masterLevel) {
		this.masterLevel = masterLevel;
		return this;
	}
	
	
	public String getLectureCurve() {
		return lectureCurve;
	}

	public StuReport setLectureCurve(String lectureCurve) {
		this.lectureCurve = lectureCurve;
		return this;
	}
	
	
	public String getLectureCurvePre() {
		return lectureCurvePre;
	}

	public StuReport setLectureCurvePre(String lectureCurvePre) {
		this.lectureCurvePre = lectureCurvePre;
		return this;
	}
	
	
	public Integer getLectureChange() {
		return lectureChange;
	}

	public StuReport setLectureChange(Integer lectureChange) {
		this.lectureChange = lectureChange;
		return this;
	}
	
	
	public Integer getLectureLevel() {
		return lectureLevel;
	}

	public StuReport setLectureLevel(Integer lectureLevel) {
		this.lectureLevel = lectureLevel;
		return this;
	}
	
	
	public Integer getLectureScore() {
		return lectureScore;
	}

	public StuReport setLectureScore(Integer lectureScore) {
		this.lectureScore = lectureScore;
		return this;
	}
	
	
	public Integer getParrentFeedbackId() {
		return parrentFeedbackId;
	}

	public StuReport setParrentFeedbackId(Integer parrentFeedbackId) {
		this.parrentFeedbackId = parrentFeedbackId;
		return this;
	}
	
	
	public Integer getIsDone() {
		return isDone;
	}

	public StuReport setIsDone(Integer isDone) {
		this.isDone = isDone;
		return this;
	}
	
	
	public Integer getIsRead() {
		return isRead;
	}

	public StuReport setIsRead(Integer isRead) {
		this.isRead = isRead;
		return this;
	}
	
	
	public Integer getTagStep() {
		return tagStep;
	}

	public StuReport setTagStep(Integer tagStep) {
		this.tagStep = tagStep;
		return this;
	}
	
	
	public Integer getHandlePeopleId() {
		return handlePeopleId;
	}

	public StuReport setHandlePeopleId(Integer handlePeopleId) {
		this.handlePeopleId = handlePeopleId;
		return this;
	}
	
	
	public String getHandlePeopleName() {
		return handlePeopleName;
	}

	public StuReport setHandlePeopleName(String handlePeopleName) {
		this.handlePeopleName = handlePeopleName;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getHandleTime() {
		return handleTime;
	}

	public StuReport setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateAt() {
		return createAt;
	}

	public StuReport setCreateAt(Date createAt) {
		this.createAt = createAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdateAt() {
		return updateAt;
	}

	public StuReport setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
		return this;
	}
	
	
	public String getStatus() {
		return status;
	}

	public StuReport setStatus(String status) {
		this.status = status;
		return this;
	}
	
	@Override
	public String toString() {
		return "StuReport [" + "id=" + getId() + ", courseId=" + courseId + ", courseName=" + courseName + ", organizationId=" + organizationId + ", schoolId=" + schoolId + ", classId=" + classId + ", className=" + className + ", skuId=" + skuId + ", skuName=" + skuName + ", stuId=" + stuId + ", stuName=" + stuName + ", totalTime=" + totalTime + ", focusAvg=" + focusAvg + ", focusRanking=" + focusRanking + ", focusChange=" + focusChange + ", focusCurve=" + focusCurve + ", focusDownIndex=" + focusDownIndex + ", focusScore=" + focusScore + ", focusLevel=" + focusLevel + ", focusImgUrl=" + focusImgUrl + ", focusVideoImgUrl=" + focusVideoImgUrl + ", focusVideoUrl=" + focusVideoUrl + ", activeAvg=" + activeAvg + ", activeRanking=" + activeRanking + ", activeChange=" + activeChange + ", activeImgUrl=" + activeImgUrl + ", activeVideoImgUrl=" + activeVideoImgUrl + ", activeVideoUrl=" + activeVideoUrl + ", activeCurve=" + activeCurve + ", activeScore=" + activeScore + ", activeHandsUp=" + activeHandsUp + ", activeLevel=" + activeLevel + ", pleasureImgUrl=" + pleasureImgUrl + ", pleasureVideoImgUrl=" + pleasureVideoImgUrl + ", pleasureVideoUrl=" + pleasureVideoUrl + ", pleasureCurve=" + pleasureCurve + ", pleasureScore=" + pleasureScore + ", pleasureChange=" + pleasureChange + ", pleasureLevel=" + pleasureLevel + ", masterCurve=" + masterCurve + ", masterCurvePre=" + masterCurvePre + ", masterScore=" + masterScore + ", masterChange=" + masterChange + ", masterLevel=" + masterLevel + ", lectureCurve=" + lectureCurve + ", lectureCurvePre=" + lectureCurvePre + ", lectureChange=" + lectureChange + ", lectureLevel=" + lectureLevel + ", lectureScore=" + lectureScore + ", parrentFeedbackId=" + parrentFeedbackId + ", isDone=" + isDone + ", isRead=" + isRead + ", tagStep=" + tagStep + ", handlePeopleId=" + handlePeopleId + ", handlePeopleName=" + handlePeopleName + ", handleTime=" + handleTime + ", createAt=" + createAt + ", updateAt=" + updateAt + ", status=" + status +  "]";
	}
}
