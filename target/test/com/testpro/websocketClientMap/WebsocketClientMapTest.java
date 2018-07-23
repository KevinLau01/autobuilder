package com.testpro.websocketClientMap;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.websocketClientMap.bean.WebsocketClientMap;
import com.testpro.websocketClientMap.bean.WebsocketClientMapSearch;
import com.testpro.websocketClientMap.service.spi.IWebsocketClientMapService;

/**
 * WebsocketClientMap JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class WebsocketClientMapTest {
	@Autowired
	private IWebsocketClientMapService websocketClientMapService;
	
	@Test
	public void find() {
		WebsocketClientMap s = websocketClientMapService.find(WebsocketClientMap.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<WebsocketClientMap> list = websocketClientMapService.queryAll(WebsocketClientMap.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			WebsocketClientMap entity = new WebsocketClientMap();
			entity.setId(1);
			websocketClientMapService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		WebsocketClientMap entity = new WebsocketClientMap();
		entity.setId(1);
		websocketClientMapService.update(entity);
	}
	
	@Test
	public void page() {
		WebsocketClientMapSearch search = new WebsocketClientMapSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<WebsocketClientMap> list = websocketClientMapService.page(WebsocketClientMap.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (WebsocketClientMap s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		websocketClientMapService.delete(WebsocketClientMap.class, 1);
		// websocketClientMapService.deleteByIds(WebsocketClientMap.class, new Object[]{3,5,9});
	}
	
}
