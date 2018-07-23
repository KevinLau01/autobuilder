package com.testpro.websocketDataCommon;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.websocketDataCommon.bean.WebsocketDataCommon;
import com.testpro.websocketDataCommon.bean.WebsocketDataCommonSearch;
import com.testpro.websocketDataCommon.service.spi.IWebsocketDataCommonService;

/**
 * WebsocketDataCommon JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class WebsocketDataCommonTest {
	@Autowired
	private IWebsocketDataCommonService websocketDataCommonService;
	
	@Test
	public void find() {
		WebsocketDataCommon s = websocketDataCommonService.find(WebsocketDataCommon.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<WebsocketDataCommon> list = websocketDataCommonService.queryAll(WebsocketDataCommon.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			WebsocketDataCommon entity = new WebsocketDataCommon();
			entity.setId(1);
			websocketDataCommonService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		WebsocketDataCommon entity = new WebsocketDataCommon();
		entity.setId(1);
		websocketDataCommonService.update(entity);
	}
	
	@Test
	public void page() {
		WebsocketDataCommonSearch search = new WebsocketDataCommonSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<WebsocketDataCommon> list = websocketDataCommonService.page(WebsocketDataCommon.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (WebsocketDataCommon s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		websocketDataCommonService.delete(WebsocketDataCommon.class, 1);
		// websocketDataCommonService.deleteByIds(WebsocketDataCommon.class, new Object[]{3,5,9});
	}
	
}
