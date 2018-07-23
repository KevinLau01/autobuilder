package com.testpro.ruleRolePermission;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.ruleRolePermission.bean.RuleRolePermission;
import com.testpro.ruleRolePermission.bean.RuleRolePermissionSearch;
import com.testpro.ruleRolePermission.service.spi.IRuleRolePermissionService;

/**
 * RuleRolePermission JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RuleRolePermissionTest {
	@Autowired
	private IRuleRolePermissionService ruleRolePermissionService;
	
	@Test
	public void find() {
		RuleRolePermission s = ruleRolePermissionService.find(RuleRolePermission.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<RuleRolePermission> list = ruleRolePermissionService.queryAll(RuleRolePermission.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			RuleRolePermission entity = new RuleRolePermission();
			entity.setId(1);
			ruleRolePermissionService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		RuleRolePermission entity = new RuleRolePermission();
		entity.setId(1);
		ruleRolePermissionService.update(entity);
	}
	
	@Test
	public void page() {
		RuleRolePermissionSearch search = new RuleRolePermissionSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<RuleRolePermission> list = ruleRolePermissionService.page(RuleRolePermission.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (RuleRolePermission s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		ruleRolePermissionService.delete(RuleRolePermission.class, 1);
		// ruleRolePermissionService.deleteByIds(RuleRolePermission.class, new Object[]{3,5,9});
	}
	
}
