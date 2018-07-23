package com.testpro.remarkWord.bean;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.testpro.common.util.ShortDateSerializer;


import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:RemarkWord
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("RemarkWord")
public class RemarkWord extends BaseEntity {
	
	
	private String	remarkType;		 /* 点评类型，1综合评分，2专注度，3活跃度，4愉悦度，5掌握度，6听课度 */ 
	private Integer	level;		 /* 等级，1表扬，2鼓励，3反思，4批评 */ 
	private String	talkType;		 /* 点评类型, 1魔镜点评，2辅导寄语 */ 
	private String	wordType;		 /* 点评类型, 话术1，话术2，话术3 */ 
	private String	remarkWord;		 /* 点评话术 */ 
	private Date	createdAt;		 /* 创建时间 */ 
	private Date	updatedAt;		 /* 更新时间 */ 
	private Date	deletedAt;		

	// Constructor
	public RemarkWord() {
	}
	
	/**
	 * full Constructor
	 */
	public RemarkWord(Integer id, String remarkType, Integer level, String talkType, String wordType, String remarkWord, Date createdAt, Date updatedAt, Date deletedAt) {
		setId(id);
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
	
	public String getRemarkType() {
		return remarkType;
	}

	public RemarkWord setRemarkType(String remarkType) {
		this.remarkType = remarkType;
		return this;
	}
	
	
	public Integer getLevel() {
		return level;
	}

	public RemarkWord setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	
	public String getTalkType() {
		return talkType;
	}

	public RemarkWord setTalkType(String talkType) {
		this.talkType = talkType;
		return this;
	}
	
	
	public String getWordType() {
		return wordType;
	}

	public RemarkWord setWordType(String wordType) {
		this.wordType = wordType;
		return this;
	}
	
	
	public String getRemarkWord() {
		return remarkWord;
	}

	public RemarkWord setRemarkWord(String remarkWord) {
		this.remarkWord = remarkWord;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreatedAt() {
		return createdAt;
	}

	public RemarkWord setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public RemarkWord setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getDeletedAt() {
		return deletedAt;
	}

	public RemarkWord setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
		return this;
	}
	
	@Override
	public String toString() {
		return "RemarkWord [" + "id=" + getId() + ", remarkType=" + remarkType + ", level=" + level + ", talkType=" + talkType + ", wordType=" + wordType + ", remarkWord=" + remarkWord + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt +  "]";
	}
}
