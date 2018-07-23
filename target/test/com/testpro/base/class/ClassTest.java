package com.testpro.base.class;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.class.bean.Class;
import com.testpro.base.class.bean.ClassSearch;
import com.testpro.base.class.service.spi.IClassService;

/**
 * Class JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ClassTest {
	@Autowired
	private IClassService classService;
	
	@Test
	public void find() {
		Class s = classService.find(Class.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Class> list = classService.queryAll(Class.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Class entity = new Class();
			entity.setId(1);
			classService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Class entity = new Class();
		entity.setId(1);
		classService.update(entity);
	}
	
	@Test
	public void page() {
		ClassSearch search = new ClassSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Class> list = classService.page(Class.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Class s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		classService.delete(Class.class, 1);
		// classService.deleteByIds(Class.class, new Object[]{3,5,9});
	}
	
}
