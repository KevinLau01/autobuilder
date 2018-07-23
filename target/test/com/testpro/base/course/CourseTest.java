package com.testpro.base.course;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.course.bean.Course;
import com.testpro.base.course.bean.CourseSearch;
import com.testpro.base.course.service.spi.ICourseService;

/**
 * Course JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CourseTest {
	@Autowired
	private ICourseService courseService;
	
	@Test
	public void find() {
		Course s = courseService.find(Course.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Course> list = courseService.queryAll(Course.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Course entity = new Course();
			entity.setId(1);
			courseService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Course entity = new Course();
		entity.setId(1);
		courseService.update(entity);
	}
	
	@Test
	public void page() {
		CourseSearch search = new CourseSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Course> list = courseService.page(Course.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Course s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		courseService.delete(Course.class, 1);
		// courseService.deleteByIds(Course.class, new Object[]{3,5,9});
	}
	
}
