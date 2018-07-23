package com.testpro.data.timeAttitude.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:TimeAttitude
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("TimeAttitude")
public class TimeAttitude extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private String	attitude;		 /* 听课状态 */ 
	private String	userAttitude;		 /* 当前分钟，所有用户的数据合集（有序） */ 
	private Integer	clientId;		 /* 客户端id */ 

	// Constructor
	public TimeAttitude() {
	}
	
	/**
	 * full Constructor
	 */
	public TimeAttitude(Integer id, Integer courseId, Integer timestamp, String attitude, String userAttitude, Integer clientId) {
		setId(id);
		this.courseId = courseId;
		this.timestamp = timestamp;
		this.attitude = attitude;
		this.userAttitude = userAttitude;
		this.clientId = clientId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为TimeAttitude可以实现连缀设置属性
	
	public Integer getCourseId() {
		return courseId;
	}

	public TimeAttitude setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public TimeAttitude setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	
	public String getAttitude() {
		return attitude;
	}

	public TimeAttitude setAttitude(String attitude) {
		this.attitude = attitude;
		return this;
	}
	
	
	public String getUserAttitude() {
		return userAttitude;
	}

	public TimeAttitude setUserAttitude(String userAttitude) {
		this.userAttitude = userAttitude;
		return this;
	}
	
	
	public Integer getClientId() {
		return clientId;
	}

	public TimeAttitude setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
	@Override
	public String toString() {
		return "TimeAttitude [" + "id=" + getId() + ", courseId=" + courseId + ", timestamp=" + timestamp + ", attitude=" + attitude + ", userAttitude=" + userAttitude + ", clientId=" + clientId +  "]";
	}
}
