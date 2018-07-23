package com.testpro.data.classFocus;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.classFocus.bean.ClassFocus;
import com.testpro.data.classFocus.bean.ClassFocusSearch;
import com.testpro.data.classFocus.service.spi.IClassFocusService;

/**
 * ClassFocus JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ClassFocusTest {
	@Autowired
	private IClassFocusService classFocusService;
	
	@Test
	public void find() {
		ClassFocus s = classFocusService.find(ClassFocus.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<ClassFocus> list = classFocusService.queryAll(ClassFocus.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			ClassFocus entity = new ClassFocus();
			entity.setId(1);
			classFocusService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		ClassFocus entity = new ClassFocus();
		entity.setId(1);
		classFocusService.update(entity);
	}
	
	@Test
	public void page() {
		ClassFocusSearch search = new ClassFocusSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<ClassFocus> list = classFocusService.page(ClassFocus.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (ClassFocus s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		classFocusService.delete(ClassFocus.class, 1);
		// classFocusService.deleteByIds(ClassFocus.class, new Object[]{3,5,9});
	}
	
}
