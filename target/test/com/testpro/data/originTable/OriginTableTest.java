package com.testpro.data.originTable;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.originTable.bean.OriginTable;
import com.testpro.data.originTable.bean.OriginTableSearch;
import com.testpro.data.originTable.service.spi.IOriginTableService;

/**
 * OriginTable JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class OriginTableTest {
	@Autowired
	private IOriginTableService originTableService;
	
	@Test
	public void find() {
		OriginTable s = originTableService.find(OriginTable.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<OriginTable> list = originTableService.queryAll(OriginTable.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			OriginTable entity = new OriginTable();
			entity.setId(1);
			originTableService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		OriginTable entity = new OriginTable();
		entity.setId(1);
		originTableService.update(entity);
	}
	
	@Test
	public void page() {
		OriginTableSearch search = new OriginTableSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<OriginTable> list = originTableService.page(OriginTable.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (OriginTable s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		originTableService.delete(OriginTable.class, 1);
		// originTableService.deleteByIds(OriginTable.class, new Object[]{3,5,9});
	}
	
}
