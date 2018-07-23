package com.testpro.data.timeAbsorbed.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:TimeAbsorbed
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("TimeAbsorbed")
public class TimeAbsorbed extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private String	absorbed;		 /* 计算的专注度值 */ 
	private String	userAbsorbed;		 /* 当前分钟，所有用户的数据合集（有序） */ 
	private Integer	clientId;		 /* 客户端id */ 

	// Constructor
	public TimeAbsorbed() {
	}
	
	/**
	 * full Constructor
	 */
	public TimeAbsorbed(Integer id, Integer courseId, Integer timestamp, String absorbed, String userAbsorbed, Integer clientId) {
		setId(id);
		this.courseId = courseId;
		this.timestamp = timestamp;
		this.absorbed = absorbed;
		this.userAbsorbed = userAbsorbed;
		this.clientId = clientId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为TimeAbsorbed可以实现连缀设置属性
	
	public Integer getCourseId() {
		return courseId;
	}

	public TimeAbsorbed setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public TimeAbsorbed setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	
	public String getAbsorbed() {
		return absorbed;
	}

	public TimeAbsorbed setAbsorbed(String absorbed) {
		this.absorbed = absorbed;
		return this;
	}
	
	
	public String getUserAbsorbed() {
		return userAbsorbed;
	}

	public TimeAbsorbed setUserAbsorbed(String userAbsorbed) {
		this.userAbsorbed = userAbsorbed;
		return this;
	}
	
	
	public Integer getClientId() {
		return clientId;
	}

	public TimeAbsorbed setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
	@Override
	public String toString() {
		return "TimeAbsorbed [" + "id=" + getId() + ", courseId=" + courseId + ", timestamp=" + timestamp + ", absorbed=" + absorbed + ", userAbsorbed=" + userAbsorbed + ", clientId=" + clientId +  "]";
	}
}
