package com.testpro.recommendQuestion;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.recommendQuestion.bean.RecommendQuestion;
import com.testpro.recommendQuestion.bean.RecommendQuestionSearch;
import com.testpro.recommendQuestion.service.spi.IRecommendQuestionService;

/**
 * RecommendQuestion JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RecommendQuestionTest {
	@Autowired
	private IRecommendQuestionService recommendQuestionService;
	
	@Test
	public void find() {
		RecommendQuestion s = recommendQuestionService.find(RecommendQuestion.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<RecommendQuestion> list = recommendQuestionService.queryAll(RecommendQuestion.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			RecommendQuestion entity = new RecommendQuestion();
			entity.setId(1);
			recommendQuestionService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		RecommendQuestion entity = new RecommendQuestion();
		entity.setId(1);
		recommendQuestionService.update(entity);
	}
	
	@Test
	public void page() {
		RecommendQuestionSearch search = new RecommendQuestionSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<RecommendQuestion> list = recommendQuestionService.page(RecommendQuestion.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (RecommendQuestion s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		recommendQuestionService.delete(RecommendQuestion.class, 1);
		// recommendQuestionService.deleteByIds(RecommendQuestion.class, new Object[]{3,5,9});
	}
	
}
