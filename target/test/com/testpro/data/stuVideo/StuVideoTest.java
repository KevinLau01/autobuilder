package com.testpro.data.stuVideo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.stuVideo.bean.StuVideo;
import com.testpro.data.stuVideo.bean.StuVideoSearch;
import com.testpro.data.stuVideo.service.spi.IStuVideoService;

/**
 * StuVideo JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuVideoTest {
	@Autowired
	private IStuVideoService stuVideoService;
	
	@Test
	public void find() {
		StuVideo s = stuVideoService.find(StuVideo.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuVideo> list = stuVideoService.queryAll(StuVideo.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuVideo entity = new StuVideo();
			entity.setId(1);
			stuVideoService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuVideo entity = new StuVideo();
		entity.setId(1);
		stuVideoService.update(entity);
	}
	
	@Test
	public void page() {
		StuVideoSearch search = new StuVideoSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuVideo> list = stuVideoService.page(StuVideo.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuVideo s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuVideoService.delete(StuVideo.class, 1);
		// stuVideoService.deleteByIds(StuVideo.class, new Object[]{3,5,9});
	}
	
}
