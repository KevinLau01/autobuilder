package com.testpro.data.timeAttitude.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:TimeAttitude
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("TimeAttitudeSearch")
public class TimeAttitudeSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private String	attitude;		 /* 听课状态 */ 
	private String	userAttitude;		 /* 当前分钟，所有用户的数据合集（有序） */ 
	private Integer	clientId;		 /* 客户端id */ 

	// Constructor
	public TimeAttitudeSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public TimeAttitudeSearch(Integer id, Integer courseId, Integer timestamp, String attitude, String userAttitude, Integer clientId) {
		this.id = id;
		this.courseId = courseId;
		this.timestamp = timestamp;
		this.attitude = attitude;
		this.userAttitude = userAttitude;
		this.clientId = clientId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为TimeAttitude可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public TimeAttitudeSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public TimeAttitudeSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public TimeAttitudeSearch setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	public String getAttitude() {
		return attitude;
	}

	public TimeAttitudeSearch setAttitude(String attitude) {
		this.attitude = attitude;
		return this;
	}
	
	public String getUserAttitude() {
		return userAttitude;
	}

	public TimeAttitudeSearch setUserAttitude(String userAttitude) {
		this.userAttitude = userAttitude;
		return this;
	}
	
	public Integer getClientId() {
		return clientId;
	}

	public TimeAttitudeSearch setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
}