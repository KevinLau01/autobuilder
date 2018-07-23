package com.testpro.stuFaceMapping.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:StuFaceMapping
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("StuFaceMapping")
public class StuFaceMapping extends BaseEntity {
	
	
	private Integer	stuId;		 /* 学生id */ 
	private String	stuName;		 /* 学生名称 */ 
	private Integer	classId;		 /* 班级id */ 
	private Integer	courseId;		 /* 课程id */ 
	private Integer	faceId;		 /* 人脸id */ 
	private String	faceImage;		 /* 人脸id对应的头像 */ 

	// Constructor
	public StuFaceMapping() {
	}
	
	/**
	 * full Constructor
	 */
	public StuFaceMapping(Integer id, Integer stuId, String stuName, Integer classId, Integer courseId, Integer faceId, String faceImage) {
		setId(id);
		this.stuId = stuId;
		this.stuName = stuName;
		this.classId = classId;
		this.courseId = courseId;
		this.faceId = faceId;
		this.faceImage = faceImage;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为StuFaceMapping可以实现连缀设置属性
	
	public Integer getStuId() {
		return stuId;
	}

	public StuFaceMapping setStuId(Integer stuId) {
		this.stuId = stuId;
		return this;
	}
	
	
	public String getStuName() {
		return stuName;
	}

	public StuFaceMapping setStuName(String stuName) {
		this.stuName = stuName;
		return this;
	}
	
	
	public Integer getClassId() {
		return classId;
	}

	public StuFaceMapping setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	
	public Integer getCourseId() {
		return courseId;
	}

	public StuFaceMapping setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getFaceId() {
		return faceId;
	}

	public StuFaceMapping setFaceId(Integer faceId) {
		this.faceId = faceId;
		return this;
	}
	
	
	public String getFaceImage() {
		return faceImage;
	}

	public StuFaceMapping setFaceImage(String faceImage) {
		this.faceImage = faceImage;
		return this;
	}
	
	@Override
	public String toString() {
		return "StuFaceMapping [" + "id=" + getId() + ", stuId=" + stuId + ", stuName=" + stuName + ", classId=" + classId + ", courseId=" + courseId + ", faceId=" + faceId + ", faceImage=" + faceImage +  "]";
	}
}
