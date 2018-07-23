package com.testpro.ruleUserRole.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:RuleUserRole
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("RuleUserRoleSearch")
public class RuleUserRoleSearch extends PageModel {
	
	private Integer	ruleRoleId;		 /* 角色id */ 
	private Integer	baseUserId;		 /* 用户id */ 

	// Constructor
	public RuleUserRoleSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public RuleUserRoleSearch(Integer ruleRoleId, Integer baseUserId) {
		this.ruleRoleId = ruleRoleId;
		this.baseUserId = baseUserId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RuleUserRole可以实现连缀设置属性
	public Integer getRuleRoleId() {
		return ruleRoleId;
	}

	public RuleUserRoleSearch setRuleRoleId(Integer ruleRoleId) {
		this.ruleRoleId = ruleRoleId;
		return this;
	}
	
	public Integer getBaseUserId() {
		return baseUserId;
	}

	public RuleUserRoleSearch setBaseUserId(Integer baseUserId) {
		this.baseUserId = baseUserId;
		return this;
	}
	
}