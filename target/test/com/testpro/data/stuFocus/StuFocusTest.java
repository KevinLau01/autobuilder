package com.testpro.data.stuFocus;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.stuFocus.bean.StuFocus;
import com.testpro.data.stuFocus.bean.StuFocusSearch;
import com.testpro.data.stuFocus.service.spi.IStuFocusService;

/**
 * StuFocus JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuFocusTest {
	@Autowired
	private IStuFocusService stuFocusService;
	
	@Test
	public void find() {
		StuFocus s = stuFocusService.find(StuFocus.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuFocus> list = stuFocusService.queryAll(StuFocus.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuFocus entity = new StuFocus();
			entity.setId(1);
			stuFocusService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuFocus entity = new StuFocus();
		entity.setId(1);
		stuFocusService.update(entity);
	}
	
	@Test
	public void page() {
		StuFocusSearch search = new StuFocusSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuFocus> list = stuFocusService.page(StuFocus.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuFocus s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuFocusService.delete(StuFocus.class, 1);
		// stuFocusService.deleteByIds(StuFocus.class, new Object[]{3,5,9});
	}
	
}
