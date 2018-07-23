package com.testpro.base.stu;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.stu.bean.Stu;
import com.testpro.base.stu.bean.StuSearch;
import com.testpro.base.stu.service.spi.IStuService;

/**
 * Stu JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuTest {
	@Autowired
	private IStuService stuService;
	
	@Test
	public void find() {
		Stu s = stuService.find(Stu.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Stu> list = stuService.queryAll(Stu.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Stu entity = new Stu();
			entity.setId(1);
			stuService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Stu entity = new Stu();
		entity.setId(1);
		stuService.update(entity);
	}
	
	@Test
	public void page() {
		StuSearch search = new StuSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Stu> list = stuService.page(Stu.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Stu s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuService.delete(Stu.class, 1);
		// stuService.deleteByIds(Stu.class, new Object[]{3,5,9});
	}
	
}
