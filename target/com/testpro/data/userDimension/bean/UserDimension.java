package com.testpro.data.userDimension.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:UserDimension
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("UserDimension")
public class UserDimension extends BaseEntity {
	
	
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private Integer	userId;		 /* 用户id */ 
	private String	userData;		 /* 当前用户，每分钟数据合集 */ 
	private String	userHeadimg;		 /* 学生头像，临时方案 */ 
	private Integer	clientId;		 /* 客户端id */ 
	private String	userAttitudeData;		 /* 学生动作历史数据 */ 
	private String	userEmotionData;		 /* 学生情绪历史数据 */ 

	// Constructor
	public UserDimension() {
	}
	
	/**
	 * full Constructor
	 */
	public UserDimension(Integer id, Integer courseId, Integer timestamp, Integer userId, String userData, String userHeadimg, Integer clientId, String userAttitudeData, String userEmotionData) {
		setId(id);
		this.courseId = courseId;
		this.timestamp = timestamp;
		this.userId = userId;
		this.userData = userData;
		this.userHeadimg = userHeadimg;
		this.clientId = clientId;
		this.userAttitudeData = userAttitudeData;
		this.userEmotionData = userEmotionData;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为UserDimension可以实现连缀设置属性
	
	public Integer getCourseId() {
		return courseId;
	}

	public UserDimension setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public UserDimension setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	
	public Integer getUserId() {
		return userId;
	}

	public UserDimension setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
	
	
	public String getUserData() {
		return userData;
	}

	public UserDimension setUserData(String userData) {
		this.userData = userData;
		return this;
	}
	
	
	public String getUserHeadimg() {
		return userHeadimg;
	}

	public UserDimension setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
		return this;
	}
	
	
	public Integer getClientId() {
		return clientId;
	}

	public UserDimension setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
	
	public String getUserAttitudeData() {
		return userAttitudeData;
	}

	public UserDimension setUserAttitudeData(String userAttitudeData) {
		this.userAttitudeData = userAttitudeData;
		return this;
	}
	
	
	public String getUserEmotionData() {
		return userEmotionData;
	}

	public UserDimension setUserEmotionData(String userEmotionData) {
		this.userEmotionData = userEmotionData;
		return this;
	}
	
	@Override
	public String toString() {
		return "UserDimension [" + "id=" + getId() + ", courseId=" + courseId + ", timestamp=" + timestamp + ", userId=" + userId + ", userData=" + userData + ", userHeadimg=" + userHeadimg + ", clientId=" + clientId + ", userAttitudeData=" + userAttitudeData + ", userEmotionData=" + userEmotionData +  "]";
	}
}
