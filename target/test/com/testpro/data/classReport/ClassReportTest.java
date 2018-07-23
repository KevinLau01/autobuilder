package com.testpro.data.classReport;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.classReport.bean.ClassReport;
import com.testpro.data.classReport.bean.ClassReportSearch;
import com.testpro.data.classReport.service.spi.IClassReportService;

/**
 * ClassReport JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ClassReportTest {
	@Autowired
	private IClassReportService classReportService;
	
	@Test
	public void find() {
		ClassReport s = classReportService.find(ClassReport.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<ClassReport> list = classReportService.queryAll(ClassReport.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			ClassReport entity = new ClassReport();
			entity.setId(1);
			classReportService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		ClassReport entity = new ClassReport();
		entity.setId(1);
		classReportService.update(entity);
	}
	
	@Test
	public void page() {
		ClassReportSearch search = new ClassReportSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<ClassReport> list = classReportService.page(ClassReport.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (ClassReport s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		classReportService.delete(ClassReport.class, 1);
		// classReportService.deleteByIds(ClassReport.class, new Object[]{3,5,9});
	}
	
}
