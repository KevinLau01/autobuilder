package com.testpro.recommendLesson;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.recommendLesson.bean.RecommendLesson;
import com.testpro.recommendLesson.bean.RecommendLessonSearch;
import com.testpro.recommendLesson.service.spi.IRecommendLessonService;

/**
 * RecommendLesson JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RecommendLessonTest {
	@Autowired
	private IRecommendLessonService recommendLessonService;
	
	@Test
	public void find() {
		RecommendLesson s = recommendLessonService.find(RecommendLesson.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<RecommendLesson> list = recommendLessonService.queryAll(RecommendLesson.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			RecommendLesson entity = new RecommendLesson();
			entity.setId(1);
			recommendLessonService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		RecommendLesson entity = new RecommendLesson();
		entity.setId(1);
		recommendLessonService.update(entity);
	}
	
	@Test
	public void page() {
		RecommendLessonSearch search = new RecommendLessonSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<RecommendLesson> list = recommendLessonService.page(RecommendLesson.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (RecommendLesson s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		recommendLessonService.delete(RecommendLesson.class, 1);
		// recommendLessonService.deleteByIds(RecommendLesson.class, new Object[]{3,5,9});
	}
	
}
