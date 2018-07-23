package com.testpro.data.timeEmotion.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:TimeEmotion
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("TimeEmotion")
public class TimeEmotion extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private String	emotion;		 /* 情绪 */ 
	private String	userEmotion;		 /* 当前分钟，所有用户的数据合集（有序） */ 
	private Integer	clientId;		 /* 客户端id */ 

	// Constructor
	public TimeEmotion() {
	}
	
	/**
	 * full Constructor
	 */
	public TimeEmotion(Integer id, Integer courseId, Integer timestamp, String emotion, String userEmotion, Integer clientId) {
		setId(id);
		this.courseId = courseId;
		this.timestamp = timestamp;
		this.emotion = emotion;
		this.userEmotion = userEmotion;
		this.clientId = clientId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为TimeEmotion可以实现连缀设置属性
	
	public Integer getCourseId() {
		return courseId;
	}

	public TimeEmotion setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public TimeEmotion setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	
	public String getEmotion() {
		return emotion;
	}

	public TimeEmotion setEmotion(String emotion) {
		this.emotion = emotion;
		return this;
	}
	
	
	public String getUserEmotion() {
		return userEmotion;
	}

	public TimeEmotion setUserEmotion(String userEmotion) {
		this.userEmotion = userEmotion;
		return this;
	}
	
	
	public Integer getClientId() {
		return clientId;
	}

	public TimeEmotion setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
	@Override
	public String toString() {
		return "TimeEmotion [" + "id=" + getId() + ", courseId=" + courseId + ", timestamp=" + timestamp + ", emotion=" + emotion + ", userEmotion=" + userEmotion + ", clientId=" + clientId +  "]";
	}
}
