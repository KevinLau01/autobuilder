package com.testpro.data.classReport.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:ClassReport
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("ClassReport")
public class ClassReport extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	classId;		 /* 班级id */ 
	private String	focusCurve;		 /* 专注度曲线 */ 
	private Integer	focusTopStuId;		 /* 专注度第一名学生id */ 
	private String	activeCurve;		 /* 活跃度曲线 */ 
	private Integer	activeTopStuId;		 /* 活跃度第一名学生id */ 
	private String	pleasureCurve;		 /* 愉悦度曲线 */ 
	private Integer	stuNum;		 /* 学生数量 */ 
	private Date	createrAt;		

	// Constructor
	public ClassReport() {
	}
	
	/**
	 * full Constructor
	 */
	public ClassReport(Integer id, Integer courseId, Integer classId, String focusCurve, Integer focusTopStuId, String activeCurve, Integer activeTopStuId, String pleasureCurve, Integer stuNum, Date createrAt) {
		setId(id);
		this.courseId = courseId;
		this.classId = classId;
		this.focusCurve = focusCurve;
		this.focusTopStuId = focusTopStuId;
		this.activeCurve = activeCurve;
		this.activeTopStuId = activeTopStuId;
		this.pleasureCurve = pleasureCurve;
		this.stuNum = stuNum;
		this.createrAt = createrAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ClassReport可以实现连缀设置属性
	
	public Integer getCourseId() {
		return courseId;
	}

	public ClassReport setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getClassId() {
		return classId;
	}

	public ClassReport setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getFocusCurve() {
		return focusCurve;
	}

	public ClassReport setFocusCurve(String focusCurve) {
		this.focusCurve = focusCurve;
		return this;
	}
	
	
	public Integer getFocusTopStuId() {
		return focusTopStuId;
	}

	public ClassReport setFocusTopStuId(Integer focusTopStuId) {
		this.focusTopStuId = focusTopStuId;
		return this;
	}
	
	
	public String getActiveCurve() {
		return activeCurve;
	}

	public ClassReport setActiveCurve(String activeCurve) {
		this.activeCurve = activeCurve;
		return this;
	}
	
	
	public Integer getActiveTopStuId() {
		return activeTopStuId;
	}

	public ClassReport setActiveTopStuId(Integer activeTopStuId) {
		this.activeTopStuId = activeTopStuId;
		return this;
	}
	
	
	public String getPleasureCurve() {
		return pleasureCurve;
	}

	public ClassReport setPleasureCurve(String pleasureCurve) {
		this.pleasureCurve = pleasureCurve;
		return this;
	}
	
	
	public Integer getStuNum() {
		return stuNum;
	}

	public ClassReport setStuNum(Integer stuNum) {
		this.stuNum = stuNum;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreaterAt() {
		return createrAt;
	}

	public ClassReport setCreaterAt(Date createrAt) {
		this.createrAt = createrAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "ClassReport [" + "id=" + getId() + ", courseId=" + courseId + ", classId=" + classId + ", focusCurve=" + focusCurve + ", focusTopStuId=" + focusTopStuId + ", activeCurve=" + activeCurve + ", activeTopStuId=" + activeTopStuId + ", pleasureCurve=" + pleasureCurve + ", stuNum=" + stuNum + ", createrAt=" + createrAt +  "]";
	}
}
