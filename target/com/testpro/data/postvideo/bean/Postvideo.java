package com.testpro.data.postvideo.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:Postvideo
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("Postvideo")
public class Postvideo extends BaseEntity {
	
	
	private String	classId;		 /* 教室编号 */ 
	private String	liveId;		 /* 直播编号 */ 
	private String	courseNumber;		 /* 课程编号 */ 
	private String	videoName;		 /* 视频名称 */ 
	private String	videoUrl;		 /* 视频保存路径 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		 /* 删除时间 */ 

	// Constructor
	public Postvideo() {
	}
	
	/**
	 * full Constructor
	 */
	public Postvideo(Integer id, String classId, String liveId, String courseNumber, String videoName, String videoUrl, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
		this.classId = classId;
		this.liveId = liveId;
		this.courseNumber = courseNumber;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Postvideo可以实现连缀设置属性
	
	public String getClassId() {
		return classId;
	}

	public Postvideo setClassId(String classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getLiveId() {
		return liveId;
	}

	public Postvideo setLiveId(String liveId) {
		this.liveId = liveId;
		return this;
	}
	
	
	public String getCourseNumber() {
		return courseNumber;
	}

	public Postvideo setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
		return this;
	}
	
	
	public String getVideoName() {
		return videoName;
	}

	public Postvideo setVideoName(String videoName) {
		this.videoName = videoName;
		return this;
	}
	
	
	public String getVideoUrl() {
		return videoUrl;
	}

	public Postvideo setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public Postvideo setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Postvideo setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public Postvideo setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "Postvideo [" + "id=" + getId() + ", classId=" + classId + ", liveId=" + liveId + ", courseNumber=" + courseNumber + ", videoName=" + videoName + ", videoUrl=" + videoUrl + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
