package com.testpro.recommendQuestionType.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:RecommendQuestionType
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("RecommendQuestionTypeSearch")
public class RecommendQuestionTypeSearch extends PageModel {
	
	private Integer	id;		
	private String	questionTypeId;		 /* 问题类型id */ 
	private String	questionTypeName;		 /* 问题名称 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public RecommendQuestionTypeSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public RecommendQuestionTypeSearch(Integer id, String questionTypeId, String questionTypeName, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.questionTypeId = questionTypeId;
		this.questionTypeName = questionTypeName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RecommendQuestionType可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public RecommendQuestionTypeSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getQuestionTypeId() {
		return questionTypeId;
	}

	public RecommendQuestionTypeSearch setQuestionTypeId(String questionTypeId) {
		this.questionTypeId = questionTypeId;
		return this;
	}
	
	public String getQuestionTypeName() {
		return questionTypeName;
	}

	public RecommendQuestionTypeSearch setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public RecommendQuestionTypeSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public RecommendQuestionTypeSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public RecommendQuestionTypeSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}