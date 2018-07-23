package com.testpro.base.classroom.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:Classroom
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ClassroomSearch")
public class ClassroomSearch extends PageModel {
	
	private Integer	id;		
	private Integer	schoolId;		 /* 学校id */ 
	private String	name;		 /* 教室名称 */ 
	private Integer	clientId;		 /* 客户端id，目前版本客户端与教室绑定 */ 
	private String	address;		 /* 学校地址 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public ClassroomSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ClassroomSearch(Integer id, Integer schoolId, String name, Integer clientId, String address, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
		this.schoolId = schoolId;
		this.name = name;
		this.clientId = clientId;
		this.address = address;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Classroom可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ClassroomSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getSchoolId() {
		return schoolId;
	}

	public ClassroomSearch setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public ClassroomSearch setName(String name) {
		this.name = name;
		return this;
	}
	
	public Integer getClientId() {
		return clientId;
	}

	public ClassroomSearch setClientId(Integer clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public String getAddress() {
		return address;
	}

	public ClassroomSearch setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public ClassroomSearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public ClassroomSearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public ClassroomSearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public ClassroomSearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public ClassroomSearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}