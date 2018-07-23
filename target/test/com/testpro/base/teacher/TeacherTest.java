package com.testpro.base.teacher;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.teacher.bean.Teacher;
import com.testpro.base.teacher.bean.TeacherSearch;
import com.testpro.base.teacher.service.spi.ITeacherService;

/**
 * Teacher JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TeacherTest {
	@Autowired
	private ITeacherService teacherService;
	
	@Test
	public void find() {
		Teacher s = teacherService.find(Teacher.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Teacher> list = teacherService.queryAll(Teacher.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Teacher entity = new Teacher();
			entity.setId(1);
			teacherService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Teacher entity = new Teacher();
		entity.setId(1);
		teacherService.update(entity);
	}
	
	@Test
	public void page() {
		TeacherSearch search = new TeacherSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Teacher> list = teacherService.page(Teacher.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Teacher s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		teacherService.delete(Teacher.class, 1);
		// teacherService.deleteByIds(Teacher.class, new Object[]{3,5,9});
	}
	
}
