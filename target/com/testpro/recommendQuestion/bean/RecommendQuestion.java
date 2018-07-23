package com.testpro.recommendQuestion.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:RecommendQuestion
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("RecommendQuestion")
public class RecommendQuestion extends BaseEntity {
	
	
	private String	questionTypeId;		 /* 问题类型id */ 
	private String	question;		 /* 问题 */ 
	private String	answer;		 /* 答案 */ 
	private Integer	level;		 /* 关联推荐level */ 
	private String	note;		 /* 备注 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public RecommendQuestion() {
	}
	
	/**
	 * full Constructor
	 */
	public RecommendQuestion(Integer id, String questionTypeId, String question, String answer, Integer level, String note, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
		this.questionTypeId = questionTypeId;
		this.question = question;
		this.answer = answer;
		this.level = level;
		this.note = note;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RecommendQuestion可以实现连缀设置属性
	
	public String getQuestionTypeId() {
		return questionTypeId;
	}

	public RecommendQuestion setQuestionTypeId(String questionTypeId) {
		this.questionTypeId = questionTypeId;
		return this;
	}
	
	
	public String getQuestion() {
		return question;
	}

	public RecommendQuestion setQuestion(String question) {
		this.question = question;
		return this;
	}
	
	
	public String getAnswer() {
		return answer;
	}

	public RecommendQuestion setAnswer(String answer) {
		this.answer = answer;
		return this;
	}
	
	
	public Integer getLevel() {
		return level;
	}

	public RecommendQuestion setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	
	public String getNote() {
		return note;
	}

	public RecommendQuestion setNote(String note) {
		this.note = note;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public RecommendQuestion setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public RecommendQuestion setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public RecommendQuestion setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "RecommendQuestion [" + "id=" + getId() + ", questionTypeId=" + questionTypeId + ", question=" + question + ", answer=" + answer + ", level=" + level + ", note=" + note + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
