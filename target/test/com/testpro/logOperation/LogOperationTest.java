package com.testpro.logOperation;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.logOperation.bean.LogOperation;
import com.testpro.logOperation.bean.LogOperationSearch;
import com.testpro.logOperation.service.spi.ILogOperationService;

/**
 * LogOperation JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class LogOperationTest {
	@Autowired
	private ILogOperationService logOperationService;
	
	@Test
	public void find() {
		LogOperation s = logOperationService.find(LogOperation.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<LogOperation> list = logOperationService.queryAll(LogOperation.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			LogOperation entity = new LogOperation();
			entity.setId(1);
			logOperationService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		LogOperation entity = new LogOperation();
		entity.setId(1);
		logOperationService.update(entity);
	}
	
	@Test
	public void page() {
		LogOperationSearch search = new LogOperationSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<LogOperation> list = logOperationService.page(LogOperation.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (LogOperation s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		logOperationService.delete(LogOperation.class, 1);
		// logOperationService.deleteByIds(LogOperation.class, new Object[]{3,5,9});
	}
	
}
