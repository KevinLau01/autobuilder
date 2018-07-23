package com.testpro.data.userDimension;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.userDimension.bean.UserDimension;
import com.testpro.data.userDimension.bean.UserDimensionSearch;
import com.testpro.data.userDimension.service.spi.IUserDimensionService;

/**
 * UserDimension JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserDimensionTest {
	@Autowired
	private IUserDimensionService userDimensionService;
	
	@Test
	public void find() {
		UserDimension s = userDimensionService.find(UserDimension.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<UserDimension> list = userDimensionService.queryAll(UserDimension.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			UserDimension entity = new UserDimension();
			entity.setId(1);
			userDimensionService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		UserDimension entity = new UserDimension();
		entity.setId(1);
		userDimensionService.update(entity);
	}
	
	@Test
	public void page() {
		UserDimensionSearch search = new UserDimensionSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<UserDimension> list = userDimensionService.page(UserDimension.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (UserDimension s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		userDimensionService.delete(UserDimension.class, 1);
		// userDimensionService.deleteByIds(UserDimension.class, new Object[]{3,5,9});
	}
	
}
