package com.testpro.base.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.user.bean.User;
import com.testpro.base.user.bean.UserSearch;
import com.testpro.base.user.service.spi.IUserService;

/**
 * User JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserTest {
	@Autowired
	private IUserService userService;
	
	@Test
	public void find() {
		User s = userService.find(User.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<User> list = userService.queryAll(User.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			User entity = new User();
			entity.setId(1);
			userService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		User entity = new User();
		entity.setId(1);
		userService.update(entity);
	}
	
	@Test
	public void page() {
		UserSearch search = new UserSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<User> list = userService.page(User.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (User s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		userService.delete(User.class, 1);
		// userService.deleteByIds(User.class, new Object[]{3,5,9});
	}
	
}
