package com.testpro.ruleUserRole;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.ruleUserRole.bean.RuleUserRole;
import com.testpro.ruleUserRole.bean.RuleUserRoleSearch;
import com.testpro.ruleUserRole.service.spi.IRuleUserRoleService;

/**
 * RuleUserRole JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RuleUserRoleTest {
	@Autowired
	private IRuleUserRoleService ruleUserRoleService;
	
	@Test
	public void find() {
		RuleUserRole s = ruleUserRoleService.find(RuleUserRole.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<RuleUserRole> list = ruleUserRoleService.queryAll(RuleUserRole.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			RuleUserRole entity = new RuleUserRole();
			entity.setId(1);
			ruleUserRoleService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		RuleUserRole entity = new RuleUserRole();
		entity.setId(1);
		ruleUserRoleService.update(entity);
	}
	
	@Test
	public void page() {
		RuleUserRoleSearch search = new RuleUserRoleSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<RuleUserRole> list = ruleUserRoleService.page(RuleUserRole.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (RuleUserRole s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		ruleUserRoleService.delete(RuleUserRole.class, 1);
		// ruleUserRoleService.deleteByIds(RuleUserRole.class, new Object[]{3,5,9});
	}
	
}
