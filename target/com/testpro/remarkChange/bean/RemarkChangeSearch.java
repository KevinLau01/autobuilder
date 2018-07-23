package com.testpro.remarkChange.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:RemarkChange
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("RemarkChangeSearch")
public class RemarkChangeSearch extends PageModel {
	
	private Integer	id;		
	private String	wordType;		 /* 点评类型, 话术1，话术2，话术3，话术3 */ 
	private Integer	changeType;		 /* 0：不变；1：提升；2：下降 */ 
	private String	remarkWord;		

	// Constructor
	public RemarkChangeSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public RemarkChangeSearch(Integer id, String wordType, Integer changeType, String remarkWord) {
		this.id = id;
		this.wordType = wordType;
		this.changeType = changeType;
		this.remarkWord = remarkWord;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RemarkChange可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public RemarkChangeSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getWordType() {
		return wordType;
	}

	public RemarkChangeSearch setWordType(String wordType) {
		this.wordType = wordType;
		return this;
	}
	
	public Integer getChangeType() {
		return changeType;
	}

	public RemarkChangeSearch setChangeType(Integer changeType) {
		this.changeType = changeType;
		return this;
	}
	
	public String getRemarkWord() {
		return remarkWord;
	}

	public RemarkChangeSearch setRemarkWord(String remarkWord) {
		this.remarkWord = remarkWord;
		return this;
	}
	
}