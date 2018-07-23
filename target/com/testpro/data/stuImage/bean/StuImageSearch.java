package com.testpro.data.stuImage.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:StuImage
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("StuImageSearch")
public class StuImageSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	stuId;		
	private Integer	layer;		 /* 维度1专注度、2活跃度、3愉悦的、4掌握度、5听课度 */ 
	private String	imageUrl;		 /* 是否已被标记 */ 
	private Integer	isMark;		 /* 是否被标注 */ 
	private Date	createdtime;		
	private Date	updatetime;		

	// Constructor
	public StuImageSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public StuImageSearch(Integer id, Integer courseId, Integer stuId, Integer layer, String imageUrl, Integer isMark, Date createdtime, Date updatetime) {
		this.id = id;
		this.courseId = courseId;
		this.stuId = stuId;
		this.layer = layer;
		this.imageUrl = imageUrl;
		this.isMark = isMark;
		this.createdtime = createdtime;
		this.updatetime = updatetime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuImage可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public StuImageSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuImageSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getStuId() {
		return stuId;
	}

	public StuImageSearch setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public Integer getLayer() {
		return layer;
	}

	public StuImageSearch setLayer(Integer layer) {
		this.layer = layer;
		return this;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public StuImageSearch setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}
	
	public Integer getIsMark() {
		return isMark;
	}

	public StuImageSearch setIsMark(Integer isMark) {
		this.isMark = isMark;
		return this;
	}
	
	public Date getCreatedtime() {
		return createdtime;
	}

	public StuImageSearch setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public Date getUpdatetime() {
		return updatetime;
	}

	public StuImageSearch setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
}