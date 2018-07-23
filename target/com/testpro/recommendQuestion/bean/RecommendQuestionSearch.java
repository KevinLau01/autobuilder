package com.testpro.recommendQuestion.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:RecommendQuestion
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("RecommendQuestionSearch")
public class RecommendQuestionSearch extends PageModel {
	
	private Integer	id;		
	private String	questionTypeId;		 /* 问题类型id */ 
	private String	question;		 /* 问题 */ 
	private String	answer;		 /* 答案 */ 
	private Integer	level;		 /* 关联推荐level */ 
	private String	note;		 /* 备注 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public RecommendQuestionSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public RecommendQuestionSearch(Integer id, String questionTypeId, String question, String answer, Integer level, String note, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
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
	public Integer getId() {
		return id;
	}

	public RecommendQuestionSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getQuestionTypeId() {
		return questionTypeId;
	}

	public RecommendQuestionSearch setQuestionTypeId(String questionTypeId) {
		this.questionTypeId = questionTypeId;
		return this;
	}
	
	public String getQuestion() {
		return question;
	}

	public RecommendQuestionSearch setQuestion(String question) {
		this.question = question;
		return this;
	}
	
	public String getAnswer() {
		return answer;
	}

	public RecommendQuestionSearch setAnswer(String answer) {
		this.answer = answer;
		return this;
	}
	
	public Integer getLevel() {
		return level;
	}

	public RecommendQuestionSearch setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	public String getNote() {
		return note;
	}

	public RecommendQuestionSearch setNote(String note) {
		this.note = note;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public RecommendQuestionSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public RecommendQuestionSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public RecommendQuestionSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}