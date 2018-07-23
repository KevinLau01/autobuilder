package com.testpro.base.city;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.city.bean.City;
import com.testpro.base.city.bean.CitySearch;
import com.testpro.base.city.service.spi.ICityService;

/**
 * City JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CityTest {
	@Autowired
	private ICityService cityService;
	
	@Test
	public void find() {
		City s = cityService.find(City.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<City> list = cityService.queryAll(City.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			City entity = new City();
			entity.setId(1);
			cityService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		City entity = new City();
		entity.setId(1);
		cityService.update(entity);
	}
	
	@Test
	public void page() {
		CitySearch search = new CitySearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<City> list = cityService.page(City.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (City s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		cityService.delete(City.class, 1);
		// cityService.deleteByIds(City.class, new Object[]{3,5,9});
	}
	
}
