package com.testpro.data.stuImage;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.stuImage.bean.StuImage;
import com.testpro.data.stuImage.bean.StuImageSearch;
import com.testpro.data.stuImage.service.spi.IStuImageService;

/**
 * StuImage JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuImageTest {
	@Autowired
	private IStuImageService stuImageService;
	
	@Test
	public void find() {
		StuImage s = stuImageService.find(StuImage.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuImage> list = stuImageService.queryAll(StuImage.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuImage entity = new StuImage();
			entity.setId(1);
			stuImageService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuImage entity = new StuImage();
		entity.setId(1);
		stuImageService.update(entity);
	}
	
	@Test
	public void page() {
		StuImageSearch search = new StuImageSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuImage> list = stuImageService.page(StuImage.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuImage s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuImageService.delete(StuImage.class, 1);
		// stuImageService.deleteByIds(StuImage.class, new Object[]{3,5,9});
	}
	
}
