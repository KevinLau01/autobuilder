package com.testpro.data.postvideoStatus.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:PostvideoStatus
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("PostvideoStatusSearch")
public class PostvideoStatusSearch extends PageModel {
	
	private Integer	id;		
	private String	classId;		 /* 教室编号 */ 
	private String	liveId;		 /* 直播编号 */ 
	private String	courseNumber;		 /* 课程编号 */ 
	private String	videoName;		 /* 视频名称 */ 
	private Integer	videoStatus;		 /* 视频状态，0不允许自动关机，1允许自动关机 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		 /* 删除时间 */ 

	// Constructor
	public PostvideoStatusSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public PostvideoStatusSearch(Integer id, String classId, String liveId, String courseNumber, String videoName, Integer videoStatus, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.classId = classId;
		this.liveId = liveId;
		this.courseNumber = courseNumber;
		this.videoName = videoName;
		this.videoStatus = videoStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为PostvideoStatus可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public PostvideoStatusSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getClassId() {
		return classId;
	}

	public PostvideoStatusSearch setClassId(String classId) {
		this.classId = classId;
		return this;
	}
	
	public String getLiveId() {
		return liveId;
	}

	public PostvideoStatusSearch setLiveId(String liveId) {
		this.liveId = liveId;
		return this;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}

	public PostvideoStatusSearch setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
		return this;
	}
	
	public String getVideoName() {
		return videoName;
	}

	public PostvideoStatusSearch setVideoName(String videoName) {
		this.videoName = videoName;
		return this;
	}
	
	public Integer getVideoStatus() {
		return videoStatus;
	}

	public PostvideoStatusSearch setVideoStatus(Integer videoStatus) {
		this.videoStatus = videoStatus;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public PostvideoStatusSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public PostvideoStatusSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public PostvideoStatusSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}