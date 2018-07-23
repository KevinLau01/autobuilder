package com.testpro.recommendQuestionType;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.recommendQuestionType.bean.RecommendQuestionType;
import com.testpro.recommendQuestionType.bean.RecommendQuestionTypeSearch;
import com.testpro.recommendQuestionType.service.spi.IRecommendQuestionTypeService;

/**
 * RecommendQuestionType JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class RecommendQuestionTypeTest {
	@Autowired
	private IRecommendQuestionTypeService recommendQuestionTypeService;
	
	@Test
	public void find() {
		RecommendQuestionType s = recommendQuestionTypeService.find(RecommendQuestionType.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<RecommendQuestionType> list = recommendQuestionTypeService.queryAll(RecommendQuestionType.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			RecommendQuestionType entity = new RecommendQuestionType();
			entity.setId(1);
			recommendQuestionTypeService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		RecommendQuestionType entity = new RecommendQuestionType();
		entity.setId(1);
		recommendQuestionTypeService.update(entity);
	}
	
	@Test
	public void page() {
		RecommendQuestionTypeSearch search = new RecommendQuestionTypeSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<RecommendQuestionType> list = recommendQuestionTypeService.page(RecommendQuestionType.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (RecommendQuestionType s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		recommendQuestionTypeService.delete(RecommendQuestionType.class, 1);
		// recommendQuestionTypeService.deleteByIds(RecommendQuestionType.class, new Object[]{3,5,9});
	}
	
}
