package com.testpro.base.organization;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.base.organization.bean.Organization;
import com.testpro.base.organization.bean.OrganizationSearch;
import com.testpro.base.organization.service.spi.IOrganizationService;

/**
 * Organization JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class OrganizationTest {
	@Autowired
	private IOrganizationService organizationService;
	
	@Test
	public void find() {
		Organization s = organizationService.find(Organization.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<Organization> list = organizationService.queryAll(Organization.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			Organization entity = new Organization();
			entity.setId(1);
			organizationService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		Organization entity = new Organization();
		entity.setId(1);
		organizationService.update(entity);
	}
	
	@Test
	public void page() {
		OrganizationSearch search = new OrganizationSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<Organization> list = organizationService.page(Organization.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (Organization s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		organizationService.delete(Organization.class, 1);
		// organizationService.deleteByIds(Organization.class, new Object[]{3,5,9});
	}
	
}
