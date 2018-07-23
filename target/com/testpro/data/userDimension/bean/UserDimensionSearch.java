package com.testpro.data.userDimension.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:UserDimension
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("UserDimensionSearch")
public class UserDimensionSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private Integer	userId;		 /* 用户id */ 
	private String	userData;		 /* 当前用户，每分钟数据合集 */ 
	private String	userHeadimg;		 /* 学生头像，临时方案 */ 
	private Integer	clientId;		 /* 客户端id */ 
	private String	userAttitudeData;		 /* 学生动作历史数据 */ 
	private String	userEmotionData;		 /* 学生情绪历史数据 */ 

	// Constructor
	public UserDimensionSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public UserDimensionSearch(Integer id, Integer courseId, Integer timestamp, Integer userId, String userData, String userHeadimg, Integer clientId, String userAttitudeData, String userEmotionData) {
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public UserDimensionSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public UserDimensionSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public UserDimensionSearch setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public UserDimensionSearch setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
	
	public String getUserData() {
		return userData;
	}

	public UserDimensionSearch setUserData(String userData) {
		this.userData = userData;
		return this;
	}
	
	public String getUserHeadimg() {
		return userHeadimg;
	}

	public UserDimensionSearch setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
		return this;
	}
	
	public Integer getClientId() {
		return clientId;
	}

	public UserDimensionSearch setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public String getUserAttitudeData() {
		return userAttitudeData;
	}

	public UserDimensionSearch setUserAttitudeData(String userAttitudeData) {
		this.userAttitudeData = userAttitudeData;
		return this;
	}
	
	public String getUserEmotionData() {
		return userEmotionData;
	}

	public UserDimensionSearch setUserEmotionData(String userEmotionData) {
		this.userEmotionData = userEmotionData;
		return this;
	}
	
}