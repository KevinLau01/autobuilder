package com.testpro.base.stuClassMapping.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:StuClassMapping
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("StuClassMappingSearch")
public class StuClassMappingSearch extends PageModel {
	
	private Integer	stuId;		 /* 学生id */ 
	private Integer	classId;		 /* 班级id */ 

	// Constructor
	public StuClassMappingSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public StuClassMappingSearch(Integer stuId, Integer classId) {
		this.stuId = stuId;
		this.classId = classId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuClassMapping可以实现连缀设置属性
	public Integer getStuId() {
		return stuId;
	}

	public StuClassMappingSearch setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public StuClassMappingSearch setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
}