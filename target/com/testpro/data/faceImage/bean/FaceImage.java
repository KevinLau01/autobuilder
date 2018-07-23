package com.testpro.data.faceImage.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:FaceImage
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("FaceImage")
public class FaceImage extends BaseEntity {
	
	
	private Integer	classId;		 /* 班级id */ 
	private String	courseId;		 /* 课程id */ 
	private Integer	faceId;		 /* 人脸id */ 
	private String	imageUrl;		

	// Constructor
	public FaceImage() {
	}
	
	/**
	 * full Constructor
	 */
	public FaceImage(Integer id, Integer classId, String courseId, Integer faceId, String imageUrl) {
		setId(id);
		this.classId = classId;
		this.courseId = courseId;
		this.faceId = faceId;
		this.imageUrl = imageUrl;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为FaceImage可以实现连缀设置属性
	
	public Integer getClassId() {
		return classId;
	}

	public FaceImage setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	
	public String getCourseId() {
		return courseId;
	}

	public FaceImage setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public Integer getFaceId() {
		return faceId;
	}

	public FaceImage setFaceId(Integer faceId) {
		this.faceId = faceId;
		return this;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public FaceImage setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}
	
	@Override
	public String toString() {
		return "FaceImage [" + "id=" + getId() + ", classId=" + classId + ", courseId=" + courseId + ", faceId=" + faceId + ", imageUrl=" + imageUrl +  "]";
	}
}
