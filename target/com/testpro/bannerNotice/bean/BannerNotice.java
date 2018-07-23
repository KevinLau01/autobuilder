package com.testpro.bannerNotice.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:BannerNotice
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("BannerNotice")
public class BannerNotice extends BaseEntity {
	
	
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
	public BannerNotice() {
	}
	
	/**
	 * full Constructor
	 */
	public BannerNotice(Integer id, String courseId, String noticeWord, Date startTime, Date endTime, Integer status, String note, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
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
	
	public String getCourseId() {
		return courseId;
	}

	public BannerNotice setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getNoticeWord() {
		return noticeWord;
	}

	public BannerNotice setNoticeWord(String noticeWord) {
		this.noticeWord = noticeWord;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getStartTime() {
		return startTime;
	}

	public BannerNotice setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}

	public BannerNotice setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public BannerNotice setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	
	public String getNote() {
		return note;
	}

	public BannerNotice setNote(String note) {
		this.note = note;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public BannerNotice setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public BannerNotice setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public BannerNotice setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "BannerNotice [" + "id=" + getId() + ", courseId=" + courseId + ", noticeWord=" + noticeWord + ", startTime=" + startTime + ", endTime=" + endTime + ", status=" + status + ", note=" + note + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
