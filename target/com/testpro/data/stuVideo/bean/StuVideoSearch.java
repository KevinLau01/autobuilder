package com.testpro.data.stuVideo.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:StuVideo
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("StuVideoSearch")
public class StuVideoSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	stuId;		
	private Integer	layer;		 /* 维度1专注度、2活跃度、3愉悦的、4掌握度、5听课度 */ 
	private String	imageUrl;		 /* 视频预览图url */ 
	private String	videoUrl;		 /* 视频url */ 
	private Integer	isMark;		 /* 是否被标注 */ 
	private Date	createdtime;		
	private Date	updatetime;		

	// Constructor
	public StuVideoSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public StuVideoSearch(Integer id, Integer courseId, Integer stuId, Integer layer, String imageUrl, String videoUrl, Integer isMark, Date createdtime, Date updatetime) {
		this.id = id;
		this.courseId = courseId;
		this.stuId = stuId;
		this.layer = layer;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
		this.isMark = isMark;
		this.createdtime = createdtime;
		this.updatetime = updatetime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuVideo可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public StuVideoSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuVideoSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getStuId() {
		return stuId;
	}

	public StuVideoSearch setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public Integer getLayer() {
		return layer;
	}

	public StuVideoSearch setLayer(Integer layer) {
		this.layer = layer;
		return this;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public StuVideoSearch setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}
	
	public String getVideoUrl() {
		return videoUrl;
	}

	public StuVideoSearch setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
		return this;
	}
	
	public Integer getIsMark() {
		return isMark;
	}

	public StuVideoSearch setIsMark(Integer isMark) {
		this.isMark = isMark;
		return this;
	}
	
	public Date getCreatedtime() {
		return createdtime;
	}

	public StuVideoSearch setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public Date getUpdatetime() {
		return updatetime;
	}

	public StuVideoSearch setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
}