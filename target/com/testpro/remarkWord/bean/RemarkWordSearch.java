package com.testpro.remarkWord.bean;

import java.util.Date;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:RemarkWord
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("RemarkWordSearch")
public class RemarkWordSearch extends PageModel {
	
	private Integer	id;		
	private String	remarkType;		 /* 点评类型，1综合评分，2专注度，3活跃度，4愉悦度，5掌握度，6听课度 */ 
	private Integer	level;		 /* 等级，1表扬，2鼓励，3反思，4批评 */ 
	private String	talkType;		 /* 点评类型, 1魔镜点评，2辅导寄语 */ 
	private String	wordType;		 /* 点评类型, 话术1，话术2，话术3 */ 
	private String	remarkWord;		 /* 点评话术 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public RemarkWordSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public RemarkWordSearch(Integer id, String remarkType, Integer level, String talkType, String wordType, String remarkWord, Date createdAt, Date updatedAt, Date deletedAt) {
		this.id = id;
		this.remarkType = remarkType;
		this.level = level;
		this.talkType = talkType;
		this.wordType = wordType;
		this.remarkWord = remarkWord;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RemarkWord可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public RemarkWordSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getRemarkType() {
		return remarkType;
	}

	public RemarkWordSearch setRemarkType(String remarkType) {
		this.remarkType = remarkType;
		return this;
	}
	
	public Integer getLevel() {
		return level;
	}

	public RemarkWordSearch setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	public String getTalkType() {
		return talkType;
	}

	public RemarkWordSearch setTalkType(String talkType) {
		this.talkType = talkType;
		return this;
	}
	
	public String getWordType() {
		return wordType;
	}

	public RemarkWordSearch setWordType(String wordType) {
		this.wordType = wordType;
		return this;
	}
	
	public String getRemarkWord() {
		return remarkWord;
	}

	public RemarkWordSearch setRemarkWord(String remarkWord) {
		this.remarkWord = remarkWord;
		return this;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public RemarkWordSearch setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public RemarkWordSearch setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public RemarkWordSearch setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
}