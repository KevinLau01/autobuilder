package com.testpro.base.stuClassMapping.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:StuClassMapping
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("StuClassMapping")
public class StuClassMapping extends BaseEntity {
	
	private Integer	stuId;		 /* 学生id */ 
	private Integer	classId;		 /* 班级id */ 

	// Constructor
	public StuClassMapping() {
	}
	
	/**
	 * full Constructor
	 */
	public StuClassMapping(Integer stuId, Integer classId) {
		this.stuId = stuId;
		this.classId = classId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuClassMapping可以实现连缀设置属性
	
	public Integer getStuId() {
		return stuId;
	}

	public StuClassMapping setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public Integer getClassId() {
		return classId;
	}

	public StuClassMapping setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	@Override
	public String toString() {
		return "StuClassMapping [" + "stuId=" + stuId + ", classId=" + classId +  "]";
	}
}
