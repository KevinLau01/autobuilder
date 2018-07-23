package com.testpro.ruleRolePermission.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:RuleRolePermission
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("RuleRolePermissionSearch")
public class RuleRolePermissionSearch extends PageModel {
	
	private Integer	ruleRoleId;		 /* 角色id */ 
	private Integer	rulePermissionId;		 /* 权限id */ 

	// Constructor
	public RuleRolePermissionSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public RuleRolePermissionSearch(Integer ruleRoleId, Integer rulePermissionId) {
		this.ruleRoleId = ruleRoleId;
		this.rulePermissionId = rulePermissionId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RuleRolePermission可以实现连缀设置属性
	public Integer getRuleRoleId() {
		return ruleRoleId;
	}

	public RuleRolePermissionSearch setRuleRoleId(Integer ruleRoleId) {
		this.ruleRoleId = ruleRoleId;
		return this;
	}
	
	public Integer getRulePermissionId() {
		return rulePermissionId;
	}

	public RuleRolePermissionSearch setRulePermissionId(Integer rulePermissionId) {
		this.rulePermissionId = rulePermissionId;
		return this;
	}
	
}