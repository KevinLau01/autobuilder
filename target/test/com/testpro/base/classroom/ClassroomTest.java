package com.testpro.base.classroom;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.classroom.bean.Classroom;
import com.testpro.base.classroom.bean.ClassroomSearch;
import com.testpro.base.classroom.service.spi.IClassroomService;

/**
 * Classroom JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ClassroomTest {
	@Autowired
	private IClassroomService classroomService;
	
	@Test
	public void find() {
		Classroom s = classroomService.find(Classroom.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Classroom> list = classroomService.queryAll(Classroom.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Classroom entity = new Classroom();
			entity.setId(1);
			classroomService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Classroom entity = new Classroom();
		entity.setId(1);
		classroomService.update(entity);
	}
	
	@Test
	public void page() {
		ClassroomSearch search = new ClassroomSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Classroom> list = classroomService.page(Classroom.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Classroom s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		classroomService.delete(Classroom.class, 1);
		// classroomService.deleteByIds(Classroom.class, new Object[]{3,5,9});
	}
	
}
