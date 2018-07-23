package com.testpro.data.stuReport;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.stuReport.bean.StuReport;
import com.testpro.data.stuReport.bean.StuReportSearch;
import com.testpro.data.stuReport.service.spi.IStuReportService;

/**
 * StuReport JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StuReportTest {
	@Autowired
	private IStuReportService stuReportService;
	
	@Test
	public void find() {
		StuReport s = stuReportService.find(StuReport.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StuReport> list = stuReportService.queryAll(StuReport.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StuReport entity = new StuReport();
			entity.setId(1);
			stuReportService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StuReport entity = new StuReport();
		entity.setId(1);
		stuReportService.update(entity);
	}
	
	@Test
	public void page() {
		StuReportSearch search = new StuReportSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StuReport> list = stuReportService.page(StuReport.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StuReport s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		stuReportService.delete(StuReport.class, 1);
		// stuReportService.deleteByIds(StuReport.class, new Object[]{3,5,9});
	}
	
}
