package com.testpro.remarkChange;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.remarkChange.bean.RemarkChange;
import com.testpro.remarkChange.bean.RemarkChangeSearch;
import com.testpro.remarkChange.service.spi.IRemarkChangeService;

/**
 * RemarkChange JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RemarkChangeTest {
	@Autowired
	private IRemarkChangeService remarkChangeService;
	
	@Test
	public void find() {
		RemarkChange s = remarkChangeService.find(RemarkChange.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<RemarkChange> list = remarkChangeService.queryAll(RemarkChange.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			RemarkChange entity = new RemarkChange();
			entity.setId(1);
			remarkChangeService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		RemarkChange entity = new RemarkChange();
		entity.setId(1);
		remarkChangeService.update(entity);
	}
	
	@Test
	public void page() {
		RemarkChangeSearch search = new RemarkChangeSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<RemarkChange> list = remarkChangeService.page(RemarkChange.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (RemarkChange s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		remarkChangeService.delete(RemarkChange.class, 1);
		// remarkChangeService.deleteByIds(RemarkChange.class, new Object[]{3,5,9});
	}
	
}
