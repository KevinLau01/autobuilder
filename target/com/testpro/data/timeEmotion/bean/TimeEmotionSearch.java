package com.testpro.data.timeEmotion.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:TimeEmotion
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("TimeEmotionSearch")
public class TimeEmotionSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private String	emotion;		 /* 情绪 */ 
	private String	userEmotion;		 /* 当前分钟，所有用户的数据合集（有序） */ 
	private Integer	clientId;		 /* 客户端id */ 

	// Constructor
	public TimeEmotionSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public TimeEmotionSearch(Integer id, Integer courseId, Integer timestamp, String emotion, String userEmotion, Integer clientId) {
		this.id = id;
		this.courseId = courseId;
		this.timestamp = timestamp;
		this.emotion = emotion;
		this.userEmotion = userEmotion;
		this.clientId = clientId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为TimeEmotion可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public TimeEmotionSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public TimeEmotionSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public TimeEmotionSearch setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	public String getEmotion() {
		return emotion;
	}

	public TimeEmotionSearch setEmotion(String emotion) {
		this.emotion = emotion;
		return this;
	}
	
	public String getUserEmotion() {
		return userEmotion;
	}

	public TimeEmotionSearch setUserEmotion(String userEmotion) {
		this.userEmotion = userEmotion;
		return this;
	}
	
	public Integer getClientId() {
		return clientId;
	}

	public TimeEmotionSearch setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
}