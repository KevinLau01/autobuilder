package com.testpro.recommendQuestionType.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:RecommendQuestionType
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("RecommendQuestionType")
public class RecommendQuestionType extends BaseEntity {
	
	
	private String	questionTypeId;		 /* 问题类型id */ 
	private String	questionTypeName;		 /* 问题名称 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public RecommendQuestionType() {
	}
	
	/**
	 * full Constructor
	 */
	public RecommendQuestionType(Integer id, String questionTypeId, String questionTypeName, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
		this.questionTypeId = questionTypeId;
		this.questionTypeName = questionTypeName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RecommendQuestionType可以实现连缀设置属性
	
	public String getQuestionTypeId() {
		return questionTypeId;
	}

	public RecommendQuestionType setQuestionTypeId(String questionTypeId) {
		this.questionTypeId = questionTypeId;
		return this;
	}
	
	
	public String getQuestionTypeName() {
		return questionTypeName;
	}

	public RecommendQuestionType setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public RecommendQuestionType setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public RecommendQuestionType setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public RecommendQuestionType setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "RecommendQuestionType [" + "id=" + getId() + ", questionTypeId=" + questionTypeId + ", questionTypeName=" + questionTypeName + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
