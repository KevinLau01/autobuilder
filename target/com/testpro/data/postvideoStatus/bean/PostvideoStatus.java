package com.testpro.data.postvideoStatus.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:PostvideoStatus
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("PostvideoStatus")
public class PostvideoStatus extends BaseEntity {
	
	
	private String	classId;		 /* 教室编号 */ 
	private String	liveId;		 /* 直播编号 */ 
	private String	courseNumber;		 /* 课程编号 */ 
	private String	videoName;		 /* 视频名称 */ 
	private Integer	videoStatus;		 /* 视频状态，0不允许自动关机，1允许自动关机 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		 /* 删除时间 */ 

	// Constructor
	public PostvideoStatus() {
	}
	
	/**
	 * full Constructor
	 */
	public PostvideoStatus(Integer id, String classId, String liveId, String courseNumber, String videoName, Integer videoStatus, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
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
	
	public String getClassId() {
		return classId;
	}

	public PostvideoStatus setClassId(String classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getLiveId() {
		return liveId;
	}

	public PostvideoStatus setLiveId(String liveId) {
		this.liveId = liveId;
		return this;
	}
	
	
	public String getCourseNumber() {
		return courseNumber;
	}

	public PostvideoStatus setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
		return this;
	}
	
	
	public String getVideoName() {
		return videoName;
	}

	public PostvideoStatus setVideoName(String videoName) {
		this.videoName = videoName;
		return this;
	}
	
	
	public Integer getVideoStatus() {
		return videoStatus;
	}

	public PostvideoStatus setVideoStatus(Integer videoStatus) {
		this.videoStatus = videoStatus;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public PostvideoStatus setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public PostvideoStatus setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public PostvideoStatus setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "PostvideoStatus [" + "id=" + getId() + ", classId=" + classId + ", liveId=" + liveId + ", courseNumber=" + courseNumber + ", videoName=" + videoName + ", videoStatus=" + videoStatus + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
