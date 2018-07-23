package com.testpro.data.faceImage.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:FaceImage
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("FaceImageSearch")
public class FaceImageSearch extends PageModel {
	
	private Integer	id;		
	private Integer	classId;		 /* 班级id */ 
	private String	courseId;		 /* 课程id */ 
	private Integer	faceId;		 /* 人脸id */ 
	private String	imageUrl;		

	// Constructor
	public FaceImageSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public FaceImageSearch(Integer id, Integer classId, String courseId, Integer faceId, String imageUrl) {
		this.id = id;
		this.classId = classId;
		this.courseId = courseId;
		this.faceId = faceId;
		this.imageUrl = imageUrl;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为FaceImage可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public FaceImageSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public FaceImageSearch setClassId(Integer classId) {
		this.classId = classId;
		return this;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public FaceImageSearch setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	
	public Integer getFaceId() {
		return faceId;
	}

	public FaceImageSearch setFaceId(Integer faceId) {
		this.faceId = faceId;
		return this;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public FaceImageSearch setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}
	
}