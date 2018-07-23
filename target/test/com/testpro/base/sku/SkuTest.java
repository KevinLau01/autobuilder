package com.testpro.base.sku;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.sku.bean.Sku;
import com.testpro.base.sku.bean.SkuSearch;
import com.testpro.base.sku.service.spi.ISkuService;

/**
 * Sku JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class SkuTest {
	@Autowired
	private ISkuService skuService;
	
	@Test
	public void find() {
		Sku s = skuService.find(Sku.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Sku> list = skuService.queryAll(Sku.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Sku entity = new Sku();
			entity.setId(1);
			skuService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Sku entity = new Sku();
		entity.setId(1);
		skuService.update(entity);
	}
	
	@Test
	public void page() {
		SkuSearch search = new SkuSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Sku> list = skuService.page(Sku.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Sku s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		skuService.delete(Sku.class, 1);
		// skuService.deleteByIds(Sku.class, new Object[]{3,5,9});
	}
	
}
