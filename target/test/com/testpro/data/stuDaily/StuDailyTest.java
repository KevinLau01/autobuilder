package com.testpro.data.stuDaily;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.stuDaily.bean.StuDaily;
import com.testpro.data.stuDaily.bean.StuDailySearch;
import com.testpro.data.stuDaily.service.spi.IStuDailyService;

/**
 * StuDaily JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuDailyTest {
	@Autowired
	private IStuDailyService stuDailyService;
	
	@Test
	public void find() {
		StuDaily s = stuDailyService.find(StuDaily.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuDaily> list = stuDailyService.queryAll(StuDaily.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuDaily entity = new StuDaily();
			entity.setId(1);
			stuDailyService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuDaily entity = new StuDaily();
		entity.setId(1);
		stuDailyService.update(entity);
	}
	
	@Test
	public void page() {
		StuDailySearch search = new StuDailySearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuDaily> list = stuDailyService.page(StuDaily.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuDaily s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuDailyService.delete(StuDaily.class, 1);
		// stuDailyService.deleteByIds(StuDaily.class, new Object[]{3,5,9});
	}
	
}
