package com.testpro.bannerNotice.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:BannerNotice
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("BannerNoticeSearch")
public class BannerNoticeSearch extends PageModel {
	
	private Integer	id;		
	private String	courseId;		 /* 在那节课通知,默认为1，所有都通知 */ 
	private String	noticeWord;		 /* 通知内容 */ 
	private Date	startTime;		 /* 开始通知时间 */ 
	private Date	endTime;		 /* 结束通知时间 */ 
	private Integer	status;		 /* 通知状态1有效，其它待审核 */ 
	private String	note;		 /* 备注 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public BannerNoticeSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public BannerNoticeSearch(Integer id, String courseId, String noticeWord, Date startTime, Date endTime, Integer status, String note, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.courseId = courseId;
		this.noticeWord = noticeWord;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.note = note;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为BannerNotice可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public BannerNoticeSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public BannerNoticeSearch setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public String getNoticeWord() {
		return noticeWord;
	}

	public BannerNoticeSearch setNoticeWord(String noticeWord) {
		this.noticeWord = noticeWord;
		return this;
	}
	
	public Date getStartTime() {
		return startTime;
	}

	public BannerNoticeSearch setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public BannerNoticeSearch setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public BannerNoticeSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public String getNote() {
		return note;
	}

	public BannerNoticeSearch setNote(String note) {
		this.note = note;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public BannerNoticeSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public BannerNoticeSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public BannerNoticeSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}