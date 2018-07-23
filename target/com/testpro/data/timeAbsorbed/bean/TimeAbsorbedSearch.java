package com.testpro.data.timeAbsorbed.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:TimeAbsorbed
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("TimeAbsorbedSearch")
public class TimeAbsorbedSearch extends PageModel {
	
	private Integer	id;		
	private Integer	courseId;		 /* 课程id */ 
	private Integer	timestamp;		 /* 数据插入时间 */ 
	private String	absorbed;		 /* 计算的专注度值 */ 
	private String	userAbsorbed;		 /* 当前分钟，所有用户的数据合集（有序） */ 
	private Integer	clientId;		 /* 客户端id */ 

	// Constructor
	public TimeAbsorbedSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public TimeAbsorbedSearch(Integer id, Integer courseId, Integer timestamp, String absorbed, String userAbsorbed, Integer clientId) {
		this.id = id;
		this.courseId = courseId;
		this.timestamp = timestamp;
		this.absorbed = absorbed;
		this.userAbsorbed = userAbsorbed;
		this.clientId = clientId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为TimeAbsorbed可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public TimeAbsorbedSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public TimeAbsorbedSearch setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public TimeAbsorbedSearch setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	public String getAbsorbed() {
		return absorbed;
	}

	public TimeAbsorbedSearch setAbsorbed(String absorbed) {
		this.absorbed = absorbed;
		return this;
	}
	
	public String getUserAbsorbed() {
		return userAbsorbed;
	}

	public TimeAbsorbedSearch setUserAbsorbed(String userAbsorbed) {
		this.userAbsorbed = userAbsorbed;
		return this;
	}
	
	public Integer getClientId() {
		return clientId;
	}

	public TimeAbsorbedSearch setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
}