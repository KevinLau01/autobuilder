package com.testpro.data.postvideoStatus;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.postvideoStatus.bean.PostvideoStatus;
import com.testpro.data.postvideoStatus.bean.PostvideoStatusSearch;
import com.testpro.data.postvideoStatus.service.spi.IPostvideoStatusService;

/**
 * PostvideoStatus JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PostvideoStatusTest {
	@Autowired
	private IPostvideoStatusService postvideoStatusService;
	
	@Test
	public void find() {
		PostvideoStatus s = postvideoStatusService.find(PostvideoStatus.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<PostvideoStatus> list = postvideoStatusService.queryAll(PostvideoStatus.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			PostvideoStatus entity = new PostvideoStatus();
			entity.setId(1);
			postvideoStatusService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		PostvideoStatus entity = new PostvideoStatus();
		entity.setId(1);
		postvideoStatusService.update(entity);
	}
	
	@Test
	public void page() {
		PostvideoStatusSearch search = new PostvideoStatusSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<PostvideoStatus> list = postvideoStatusService.page(PostvideoStatus.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (PostvideoStatus s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		postvideoStatusService.delete(PostvideoStatus.class, 1);
		// postvideoStatusService.deleteByIds(PostvideoStatus.class, new Object[]{3,5,9});
	}
	
}
