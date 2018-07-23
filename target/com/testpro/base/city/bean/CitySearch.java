package com.testpro.base.city.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:City
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("CitySearch")
public class CitySearch extends PageModel {
	
	private Integer	id;		 /* id */ 
	private String	name;		 /* 城市名称 */ 
	private String	code;		 /* 城市编码 */ 
	private Integer	deleted;		 /* 0未删除 1已删除 */ 
	private Integer	createdtime;		 /* 创建时间 */ 
	private String	createdUser;		 /* 创建人 */ 
	private Integer	updatetime;		 /* 修改时间 */ 
	private String	updateUser;		 /* 修改人 */ 

	// Constructor
	public CitySearch() {
	}
	
	/**
	 * full Constructor
	 */
	public CitySearch(Integer id, String name, String code, Integer deleted, Integer createdtime, String createdUser, Integer updatetime, String updateUser) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.deleted = deleted;
		this.createdtime = createdtime;
		this.createdUser = createdUser;
		this.updatetime = updatetime;
		this.updateUser = updateUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为City可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public CitySearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}

	public CitySearch setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getCode() {
		return code;
	}

	public CitySearch setCode(String code) {
		this.code = code;
		return this;
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public CitySearch setDeleted(Integer deleted) {
		this.deleted = deleted;
		return this;
	}
	
	public Integer getCreatedtime() {
		return createdtime;
	}

	public CitySearch setCreatedtime(Integer createdtime) {
		this.createdtime = createdtime;
		return this;
	}
	
	public String getCreatedUser() {
		return createdUser;
	}

	public CitySearch setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
		return this;
	}
	
	public Integer getUpdatetime() {
		return updatetime;
	}

	public CitySearch setUpdatetime(Integer updatetime) {
		this.updatetime = updatetime;
		return this;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public CitySearch setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
		return this;
	}
	
}