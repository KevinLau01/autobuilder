package com.testpro.base.school;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.school.bean.School;
import com.testpro.base.school.bean.SchoolSearch;
import com.testpro.base.school.service.spi.ISchoolService;

/**
 * School JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class SchoolTest {
	@Autowired
	private ISchoolService schoolService;
	
	@Test
	public void find() {
		School s = schoolService.find(School.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<School> list = schoolService.queryAll(School.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			School entity = new School();
			entity.setId(1);
			schoolService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		School entity = new School();
		entity.setId(1);
		schoolService.update(entity);
	}
	
	@Test
	public void page() {
		SchoolSearch search = new SchoolSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<School> list = schoolService.page(School.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (School s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		schoolService.delete(School.class, 1);
		// schoolService.deleteByIds(School.class, new Object[]{3,5,9});
	}
	
}
