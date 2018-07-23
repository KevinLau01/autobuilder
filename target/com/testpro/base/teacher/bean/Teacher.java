package com.testpro.base.teacher.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:Teacher
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("Teacher")
public class Teacher extends BaseEntity {
	
	private Integer	userId;		 /* 用户id */ 
	
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
	public Teacher() {
	}
	
	/**
	 * full Constructor
	 */
	public Teacher(Integer userId, Integer id, Integer schoolId, String name, String telphone, String address, String remark, Integer level, String technicalTitle, String headImg, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.userId = userId;
		setId(id);
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

	public Teacher setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
	
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public Teacher setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	
	public String getName() {
		return name;
	}

	public Teacher setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getTelphone() {
		return telphone;
	}

	public Teacher setTelphone(String telphone) {
		this.telphone = telphone;
		return this;
	}
	
	
	public String getAddress() {
		return address;
	}

	public Teacher setAddress(String address) {
		this.address = address;
		return this;
	}
	
	
	public String getRemark() {
		return remark;
	}

	public Teacher setRemark(String remark) {
		this.remark = remark;
		return this;
	}
	
	
	public Integer getLevel() {
		return level;
	}

	public Teacher setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	
	public String getTechnicalTitle() {
		return technicalTitle;
	}

	public Teacher setTechnicalTitle(String technicalTitle) {
		this.technicalTitle = technicalTitle;
		return this;
	}
	
	
	public String getHeadImg() {
		return headImg;
	}

	public Teacher setHeadImg(String headImg) {
		this.headImg = headImg;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public Teacher setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public Teacher setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public Teacher setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public Teacher setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public Teacher setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "Teacher [" + "userId=" + userId + ", id=" + getId() + ", schoolId=" + schoolId + ", name=" + name + ", telphone=" + telphone + ", address=" + address + ", remark=" + remark + ", level=" + level + ", technicalTitle=" + technicalTitle + ", headImg=" + headImg + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser +  "]";
	}
}
