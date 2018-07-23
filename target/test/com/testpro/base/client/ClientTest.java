package com.testpro.base.client;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.client.bean.Client;
import com.testpro.base.client.bean.ClientSearch;
import com.testpro.base.client.service.spi.IClientService;

/**
 * Client JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ClientTest {
	@Autowired
	private IClientService clientService;
	
	@Test
	public void find() {
		Client s = clientService.find(Client.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Client> list = clientService.queryAll(Client.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Client entity = new Client();
			entity.setId(1);
			clientService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Client entity = new Client();
		entity.setId(1);
		clientService.update(entity);
	}
	
	@Test
	public void page() {
		ClientSearch search = new ClientSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Client> list = clientService.page(Client.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Client s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		clientService.delete(Client.class, 1);
		// clientService.deleteByIds(Client.class, new Object[]{3,5,9});
	}
	
}
