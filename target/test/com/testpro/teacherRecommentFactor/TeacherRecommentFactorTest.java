package com.testpro.teacherRecommentFactor;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.teacherRecommentFactor.bean.TeacherRecommentFactor;
import com.testpro.teacherRecommentFactor.bean.TeacherRecommentFactorSearch;
import com.testpro.teacherRecommentFactor.service.spi.ITeacherRecommentFactorService;

/**
 * TeacherRecommentFactor JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TeacherRecommentFactorTest {
	@Autowired
	private ITeacherRecommentFactorService teacherRecommentFactorService;
	
	@Test
	public void find() {
		TeacherRecommentFactor s = teacherRecommentFactorService.find(TeacherRecommentFactor.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<TeacherRecommentFactor> list = teacherRecommentFactorService.queryAll(TeacherRecommentFactor.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			TeacherRecommentFactor entity = new TeacherRecommentFactor();
			entity.setId(1);
			teacherRecommentFactorService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		TeacherRecommentFactor entity = new TeacherRecommentFactor();
		entity.setId(1);
		teacherRecommentFactorService.update(entity);
	}
	
	@Test
	public void page() {
		TeacherRecommentFactorSearch search = new TeacherRecommentFactorSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<TeacherRecommentFactor> list = teacherRecommentFactorService.page(TeacherRecommentFactor.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (TeacherRecommentFactor s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		teacherRecommentFactorService.delete(TeacherRecommentFactor.class, 1);
		// teacherRecommentFactorService.deleteByIds(TeacherRecommentFactor.class, new Object[]{3,5,9});
	}
	
}
