package com.testpro.websocketDataCommon.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:WebsocketDataCommon
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("WebsocketDataCommonSearch")
public class WebsocketDataCommonSearch extends PageModel {
	
	private Integer	id;		 /* 主键 */ 
	private String	channelId;		 /* 渠道id或机构id */ 
	private String	clientId;		 /* 客户端id */ 
	private String	courseId;		 /* 课程id */ 
	private Integer	dFreq;		 /* 两帧之间间隔的帧数 */ 
	private Integer	fps;		 /* 每秒多少帧 */ 
	private Date	startTime;		 /* 开始时间 */ 
	private Date	endTime;		 /* 结束时间 */ 
	private Integer	videoStartTimestamp;		 /* 视频开始时间戳 */ 
	private String	opType;		 /* 协议类型 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		 /* 删除时间 */ 

	// Constructor
	public WebsocketDataCommonSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public WebsocketDataCommonSearch(Integer id, String channelId, String clientId, String courseId, Integer dFreq, Integer fps, Date startTime, Date endTime, Integer videoStartTimestamp, String opType, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.channelId = channelId;
		this.clientId = clientId;
		this.courseId = courseId;
		this.dFreq = dFreq;
		this.fps = fps;
		this.startTime = startTime;
		this.endTime = endTime;
		this.videoStartTimestamp = videoStartTimestamp;
		this.opType = opType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为WebsocketDataCommon可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public WebsocketDataCommonSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getChannelId() {
		return channelId;
	}

	public WebsocketDataCommonSearch setChannelId(String channelId) {
		this.channelId = channelId;
		return this;
	}
	
	public String getClientId() {
		return clientId;
	}

	public WebsocketDataCommonSearch setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public WebsocketDataCommonSearch setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getDFreq() {
		return dFreq;
	}

	public WebsocketDataCommonSearch setDFreq(Integer dFreq) {
		this.dFreq = dFreq;
		return this;
	}
	
	public Integer getFps() {
		return fps;
	}

	public WebsocketDataCommonSearch setFps(Integer fps) {
		this.fps = fps;
		return this;
	}
	
	public Date getStartTime() {
		return startTime;
	}

	public WebsocketDataCommonSearch setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public WebsocketDataCommonSearch setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public Integer getVideoStartTimestamp() {
		return videoStartTimestamp;
	}

	public WebsocketDataCommonSearch setVideoStartTimestamp(Integer videoStartTimestamp) {
		this.videoStartTimestamp = videoStartTimestamp;
		return this;
	}
	
	public String getOpType() {
		return opType;
	}

	public WebsocketDataCommonSearch setOpType(String opType) {
		this.opType = opType;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public WebsocketDataCommonSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public WebsocketDataCommonSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public WebsocketDataCommonSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}