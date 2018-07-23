package com.testpro.data.timeAttitude;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.timeAttitude.bean.TimeAttitude;
import com.testpro.data.timeAttitude.bean.TimeAttitudeSearch;
import com.testpro.data.timeAttitude.service.spi.ITimeAttitudeService;

/**
 * TimeAttitude JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TimeAttitudeTest {
	@Autowired
	private ITimeAttitudeService timeAttitudeService;
	
	@Test
	public void find() {
		TimeAttitude s = timeAttitudeService.find(TimeAttitude.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<TimeAttitude> list = timeAttitudeService.queryAll(TimeAttitude.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			TimeAttitude entity = new TimeAttitude();
			entity.setId(1);
			timeAttitudeService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		TimeAttitude entity = new TimeAttitude();
		entity.setId(1);
		timeAttitudeService.update(entity);
	}
	
	@Test
	public void page() {
		TimeAttitudeSearch search = new TimeAttitudeSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<TimeAttitude> list = timeAttitudeService.page(TimeAttitude.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (TimeAttitude s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		timeAttitudeService.delete(TimeAttitude.class, 1);
		// timeAttitudeService.deleteByIds(TimeAttitude.class, new Object[]{3,5,9});
	}
	
}
