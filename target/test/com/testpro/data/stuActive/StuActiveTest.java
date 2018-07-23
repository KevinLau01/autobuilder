package com.testpro.data.stuActive;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.stuActive.bean.StuActive;
import com.testpro.data.stuActive.bean.StuActiveSearch;
import com.testpro.data.stuActive.service.spi.IStuActiveService;

/**
 * StuActive JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuActiveTest {
	@Autowired
	private IStuActiveService stuActiveService;
	
	@Test
	public void find() {
		StuActive s = stuActiveService.find(StuActive.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuActive> list = stuActiveService.queryAll(StuActive.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuActive entity = new StuActive();
			entity.setId(1);
			stuActiveService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuActive entity = new StuActive();
		entity.setId(1);
		stuActiveService.update(entity);
	}
	
	@Test
	public void page() {
		StuActiveSearch search = new StuActiveSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuActive> list = stuActiveService.page(StuActive.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuActive s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuActiveService.delete(StuActive.class, 1);
		// stuActiveService.deleteByIds(StuActive.class, new Object[]{3,5,9});
	}
	
}
