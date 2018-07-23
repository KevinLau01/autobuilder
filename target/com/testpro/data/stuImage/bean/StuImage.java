package com.testpro.data.stuImage.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:StuImage
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("StuImage")
public class StuImage extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	stuId;		
	private Integer	layer;		 /* 维度1专注度、2活跃度、3愉悦的、4掌握度、5听课度 */ 
	private String	imageUrl;		 /* 是否已被标记 */ 
	private Integer	isMark;		 /* 是否被标注 */ 
	private Date	createdtime;		
	private Date	updatetime;		

	// Constructor
	public StuImage() {
	}
	
	/**
	 * full Constructor
	 */
	public StuImage(Integer id, Integer courseId, Integer stuId, Integer layer, String imageUrl, Integer isMark, Date createdtime, Date updatetime) {
		setId(id);
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
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuImage setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getStuId() {
		return stuId;
	}

	public StuImage setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public Integer getLayer() {
		return layer;
	}

	public StuImage setLayer(Integer layer) {
		this.layer = layer;
		return this;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public StuImage setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}
	
	
	public Integer getIsMark() {
		return isMark;
	}

	public StuImage setIsMark(Integer isMark) {
		this.isMark = isMark;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedtime() {
		return createdtime;
	}

	public StuImage setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatetime() {
		return updatetime;
	}

	public StuImage setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	@Override
	public String toString() {
		return "StuImage [" + "id=" + getId() + ", courseId=" + courseId + ", stuId=" + stuId + ", layer=" + layer + ", imageUrl=" + imageUrl + ", isMark=" + isMark + ", createdtime=" + createdtime + ", updatetime=" + updatetime +  "]";
	}
}
