package com.testpro.remarkChange.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:RemarkChange
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("RemarkChange")
public class RemarkChange extends BaseEntity {
	
	
	private String	wordType;		 /* 点评类型, 话术1，话术2，话术3，话术3 */ 
	private Integer	changeType;		 /* 0：不变；1：提升；2：下降 */ 
	private String	remarkWord;		

	// Constructor
	public RemarkChange() {
	}
	
	/**
	 * full Constructor
	 */
	public RemarkChange(Integer id, String wordType, Integer changeType, String remarkWord) {
		setId(id);
		this.wordType = wordType;
		this.changeType = changeType;
		this.remarkWord = remarkWord;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RemarkChange可以实现连缀设置属性
	
	public String getWordType() {
		return wordType;
	}

	public RemarkChange setWordType(String wordType) {
		this.wordType = wordType;
		return this;
	}
	
	
	public Integer getChangeType() {
		return changeType;
	}

	public RemarkChange setChangeType(Integer changeType) {
		this.changeType = changeType;
		return this;
	}
	
	
	public String getRemarkWord() {
		return remarkWord;
	}

	public RemarkChange setRemarkWord(String remarkWord) {
		this.remarkWord = remarkWord;
		return this;
	}
	
	@Override
	public String toString() {
		return "RemarkChange [" + "id=" + getId() + ", wordType=" + wordType + ", changeType=" + changeType + ", remarkWord=" + remarkWord +  "]";
	}
}
