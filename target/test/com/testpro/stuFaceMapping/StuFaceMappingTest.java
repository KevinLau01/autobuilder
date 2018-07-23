package com.testpro.stuFaceMapping;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.stuFaceMapping.bean.StuFaceMapping;
import com.testpro.stuFaceMapping.bean.StuFaceMappingSearch;
import com.testpro.stuFaceMapping.service.spi.IStuFaceMappingService;

/**
 * StuFaceMapping JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuFaceMappingTest {
	@Autowired
	private IStuFaceMappingService stuFaceMappingService;
	
	@Test
	public void find() {
		StuFaceMapping s = stuFaceMappingService.find(StuFaceMapping.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuFaceMapping> list = stuFaceMappingService.queryAll(StuFaceMapping.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuFaceMapping entity = new StuFaceMapping();
			entity.setId(1);
			stuFaceMappingService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuFaceMapping entity = new StuFaceMapping();
		entity.setId(1);
		stuFaceMappingService.update(entity);
	}
	
	@Test
	public void page() {
		StuFaceMappingSearch search = new StuFaceMappingSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuFaceMapping> list = stuFaceMappingService.page(StuFaceMapping.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuFaceMapping s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuFaceMappingService.delete(StuFaceMapping.class, 1);
		// stuFaceMappingService.deleteByIds(StuFaceMapping.class, new Object[]{3,5,9});
	}
	
}
