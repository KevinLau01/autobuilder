package com.testpro.base.class.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:Class
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ClassSearch")
public class ClassSearch extends PageModel {
	
	private Integer	id;		
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
	public ClassSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ClassSearch(Integer id, String teacherId, String teacherName, String name, Integer schoolId, String grade, Integer organizationId, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public ClassSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getTeacherId() {
		return teacherId;
	}

	public ClassSearch setTeacherId(String teacherId) {
		this.teacherId = teacherId;
		return this;
	}
	
	public String getTeacherName() {
		return teacherName;
	}

	public ClassSearch setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public ClassSearch setName(String name) {
		this.name = name;
		return this;
	}
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public ClassSearch setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	public String getGrade() {
		return grade;
	}

	public ClassSearch setGrade(String grade) {
		this.grade = grade;
		return this;
	}
	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public ClassSearch setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public ClassSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public ClassSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public ClassSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public ClassSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public ClassSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}