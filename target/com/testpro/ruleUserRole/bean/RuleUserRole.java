package com.testpro.ruleUserRole.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:RuleUserRole
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("RuleUserRole")
public class RuleUserRole extends BaseEntity {
	
	private Integer	ruleRoleId;		 /* 角色id */ 
	private Integer	baseUserId;		 /* 用户id */ 

	// Constructor
	public RuleUserRole() {
	}
	
	/**
	 * full Constructor
	 */
	public RuleUserRole(Integer ruleRoleId, Integer baseUserId) {
		this.ruleRoleId = ruleRoleId;
		this.baseUserId = baseUserId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RuleUserRole可以实现连缀设置属性
	
	public Integer getRuleRoleId() {
		return ruleRoleId;
	}

	public RuleUserRole setRuleRoleId(Integer ruleRoleId) {
		this.ruleRoleId = ruleRoleId;
		return this;
	}
	
	
	public Integer getBaseUserId() {
		return baseUserId;
	}

	public RuleUserRole setBaseUserId(Integer baseUserId) {
		this.baseUserId = baseUserId;
		return this;
	}
	
	@Override
	public String toString() {
		return "RuleUserRole [" + "ruleRoleId=" + ruleRoleId + ", baseUserId=" + baseUserId +  "]";
	}
}
