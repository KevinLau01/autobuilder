package com.testpro.base.stuClassMapping;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.stuClassMapping.bean.StuClassMapping;
import com.testpro.base.stuClassMapping.bean.StuClassMappingSearch;
import com.testpro.base.stuClassMapping.service.spi.IStuClassMappingService;

/**
 * StuClassMapping JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuClassMappingTest {
	@Autowired
	private IStuClassMappingService stuClassMappingService;
	
	@Test
	public void find() {
		StuClassMapping s = stuClassMappingService.find(StuClassMapping.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuClassMapping> list = stuClassMappingService.queryAll(StuClassMapping.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuClassMapping entity = new StuClassMapping();
			entity.setId(1);
			stuClassMappingService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuClassMapping entity = new StuClassMapping();
		entity.setId(1);
		stuClassMappingService.update(entity);
	}
	
	@Test
	public void page() {
		StuClassMappingSearch search = new StuClassMappingSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuClassMapping> list = stuClassMappingService.page(StuClassMapping.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuClassMapping s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuClassMappingService.delete(StuClassMapping.class, 1);
		// stuClassMappingService.deleteByIds(StuClassMapping.class, new Object[]{3,5,9});
	}
	
}
