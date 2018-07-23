package com.testpro.base.stu.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:Stu
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("Stu")
public class Stu extends BaseEntity {
	
	
	private String	name;		 /* 姓名 */ 
	private String	number;		 /* 学号 */ 
	private String	headImg;		 /* 头像 */ 
	private String	parentsName;		 /* 家长姓名 */ 
	private String	parentsPhone;		 /* 家长电话 */ 
	private String	loginId;		 /* 登录账号-手机号 */ 
	private String	password;		 /* 登录密码 */ 
	private String	headCircularImg;		 /* 剪裁后的头像 */ 
	private Integer	headImgStatus;		 /* 头像状态 0未修正 1被打回 2已修正 3全部 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 
	private Integer	activated;		
	private Integer	orgId;		

	// Constructor
	public Stu() {
	}
	
	/**
	 * full Constructor
	 */
	public Stu(Integer id, String name, String number, String headImg, String parentsName, String parentsPhone, String loginId, String password, String headCircularImg, Integer headImgStatus, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser, Integer activated, Integer orgId) {
		setId(id);
		this.name = name;
		this.number = number;
		this.headImg = headImg;
		this.parentsName = parentsName;
		this.parentsPhone = parentsPhone;
		this.loginId = loginId;
		this.password = password;
		this.headCircularImg = headCircularImg;
		this.headImgStatus = headImgStatus;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
		this.activated = activated;
		this.orgId = orgId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Stu可以实现连缀设置属性
	
	public String getName() {
		return name;
	}

	public Stu setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getNumber() {
		return number;
	}

	public Stu setNumber(String number) {
		this.number = number;
		return this;
	}
	
	
	public String getHeadImg() {
		return headImg;
	}

	public Stu setHeadImg(String headImg) {
		this.headImg = headImg;
		return this;
	}
	
	
	public String getParentsName() {
		return parentsName;
	}

	public Stu setParentsName(String parentsName) {
		this.parentsName = parentsName;
		return this;
	}
	
	
	public String getParentsPhone() {
		return parentsPhone;
	}

	public Stu setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
		return this;
	}
	
	
	public String getLoginId() {
		return loginId;
	}

	public Stu setLoginId(String loginId) {
		this.loginId = loginId;
		return this;
	}
	
	
	public String getPassword() {
		return password;
	}

	public Stu setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	public String getHeadCircularImg() {
		return headCircularImg;
	}

	public Stu setHeadCircularImg(String headCircularImg) {
		this.headCircularImg = headCircularImg;
		return this;
	}
	
	
	public Integer getHeadImgStatus() {
		return headImgStatus;
	}

	public Stu setHeadImgStatus(Integer headImgStatus) {
		this.headImgStatus = headImgStatus;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public Stu setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public Stu setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public Stu setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public Stu setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public Stu setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	
	public Integer getActivated() {
		return activated;
	}

	public Stu setActivated(Integer activated) {
		this.activated = activated;
		return this;
	}
	
	
	public Integer getOrgId() {
		return orgId;
	}

	public Stu setOrgId(Integer orgId) {
		this.orgId = orgId;
		return this;
	}
	
	@Override
	public String toString() {
		return "Stu [" + "id=" + getId() + ", name=" + name + ", number=" + number + ", headImg=" + headImg + ", parentsName=" + parentsName + ", parentsPhone=" + parentsPhone + ", loginId=" + loginId + ", password=" + password + ", headCircularImg=" + headCircularImg + ", headImgStatus=" + headImgStatus + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser + ", activated=" + activated + ", orgId=" + orgId +  "]";
	}
}
