package com.testpro.base.class.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:Class
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("Class")
public class Class extends BaseEntity {
	
	
	private String	teacherId;		 /* 班主任id
 */ 
	private String	teacherName;		 /* 班主任名称 */ 
	private String	name;		 /* 班级名称 */ 
	private Integer	schoolId;		 /* 学校id */ 
	private String	grade;		 /* 年级（文字） */ 
	private Integer	organizationId;		 /* 机构id */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public Class() {
	}
	
	/**
	 * full Constructor
	 */
	public Class(Integer id, String teacherId, String teacherName, String name, Integer schoolId, String grade, Integer organizationId, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		setId(id);
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.name = name;
		this.schoolId = schoolId;
		this.grade = grade;
		this.organizationId = organizationId;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Class可以实现连缀设置属性
	
	public String getTeacherId() {
		return teacherId;
	}

	public Class setTeacherId(String teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	
	public String getTeacherName() {
		return teacherName;
	}

	public Class setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		return this;
	}
	
	
	public String getName() {
		return name;
	}

	public Class setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public Class setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	
	public String getGrade() {
		return grade;
	}

	public Class setGrade(String grade) {
		this.grade = grade;
		return this;
	}
	
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public Class setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	
	public Integer getDeleted() {
		return deleted;
	}

	public Class setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public Class setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	
	public String getCreatedUser() {
		return createdUser;
	}

	public Class setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public Class setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public Class setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "Class [" + "id=" + getId() + ", teacherId=" + teacherId + ", teacherName=" + teacherName + ", name=" + name + ", schoolId=" + schoolId + ", grade=" + grade + ", organizationId=" + organizationId + ", deleted=" + deleted + ", createdtime=" + createdtime + ", createdUser=" + createdUser + ", updatetime=" + updatetime + ", updateUser=" + updateUser +  "]";
	}
}
