package com.testpro.base.teacher.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:Teacher
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("TeacherSearch")
public class TeacherSearch extends PageModel {
	
	private Integer	userId;		 /* 用户id */ 
	private Integer	id;		
	private Integer	schoolId;		 /* 学校id */ 
	private String	name;		 /* 名称 */ 
	private String	telphone;		 /* 电话 */ 
	private String	address;		 /* 地址 */ 
	private String	remark;		 /* 备注 */ 
	private Integer	level;		 /* 级别 */ 
	private String	technicalTitle;		 /* 职称 */ 
	private String	headImg;		 /* 头像 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public TeacherSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public TeacherSearch(Integer userId, Integer id, Integer schoolId, String name, String telphone, String address, String remark, Integer level, String technicalTitle, String headImg, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.userId = userId;
		this.id = id;
		this.schoolId = schoolId;
		this.name = name;
		this.telphone = telphone;
		this.address = address;
		this.remark = remark;
		this.level = level;
		this.technicalTitle = technicalTitle;
		this.headImg = headImg;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Teacher可以实现连缀设置属性
	public Integer getUserId() {
		return userId;
	}

	public TeacherSearch setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
	
	public Integer getId() {
		return id;
	}

	public TeacherSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public TeacherSearch setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public TeacherSearch setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getTelphone() {
		return telphone;
	}

	public TeacherSearch setTelphone(String telphone) {
		this.telphone = telphone;
		return this;
	}
	
	public String getAddress() {
		return address;
	}

	public TeacherSearch setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public String getRemark() {
		return remark;
	}

	public TeacherSearch setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	
	public Integer getLevel() {
		return level;
	}

	public TeacherSearch setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	public String getTechnicalTitle() {
		return technicalTitle;
	}

	public TeacherSearch setTechnicalTitle(String technicalTitle) {
		this.technicalTitle = technicalTitle;
		return this;
	}
	
	public String getHeadImg() {
		return headImg;
	}

	public TeacherSearch setHeadImg(String headImg) {
		this.headImg = headImg;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public TeacherSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public TeacherSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public TeacherSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public TeacherSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public TeacherSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}