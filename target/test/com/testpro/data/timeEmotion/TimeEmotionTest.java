package com.testpro.data.timeEmotion;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.timeEmotion.bean.TimeEmotion;
import com.testpro.data.timeEmotion.bean.TimeEmotionSearch;
import com.testpro.data.timeEmotion.service.spi.ITimeEmotionService;

/**
 * TimeEmotion JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TimeEmotionTest {
	@Autowired
	private ITimeEmotionService timeEmotionService;
	
	@Test
	public void find() {
		TimeEmotion s = timeEmotionService.find(TimeEmotion.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<TimeEmotion> list = timeEmotionService.queryAll(TimeEmotion.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			TimeEmotion entity = new TimeEmotion();
			entity.setId(1);
			timeEmotionService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		TimeEmotion entity = new TimeEmotion();
		entity.setId(1);
		timeEmotionService.update(entity);
	}
	
	@Test
	public void page() {
		TimeEmotionSearch search = new TimeEmotionSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<TimeEmotion> list = timeEmotionService.page(TimeEmotion.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (TimeEmotion s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		timeEmotionService.delete(TimeEmotion.class, 1);
		// timeEmotionService.deleteByIds(TimeEmotion.class, new Object[]{3,5,9});
	}
	
}
