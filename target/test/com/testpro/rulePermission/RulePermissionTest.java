package com.testpro.rulePermission;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.rulePermission.bean.RulePermission;
import com.testpro.rulePermission.bean.RulePermissionSearch;
import com.testpro.rulePermission.service.spi.IRulePermissionService;

/**
 * RulePermission JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RulePermissionTest {
	@Autowired
	private IRulePermissionService rulePermissionService;
	
	@Test
	public void find() {
		RulePermission s = rulePermissionService.find(RulePermission.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<RulePermission> list = rulePermissionService.queryAll(RulePermission.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			RulePermission entity = new RulePermission();
			entity.setId(1);
			rulePermissionService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		RulePermission entity = new RulePermission();
		entity.setId(1);
		rulePermissionService.update(entity);
	}
	
	@Test
	public void page() {
		RulePermissionSearch search = new RulePermissionSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<RulePermission> list = rulePermissionService.page(RulePermission.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (RulePermission s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		rulePermissionService.delete(RulePermission.class, 1);
		// rulePermissionService.deleteByIds(RulePermission.class, new Object[]{3,5,9});
	}
	
}
