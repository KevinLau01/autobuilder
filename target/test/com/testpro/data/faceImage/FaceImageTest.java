package com.testpro.data.faceImage;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.exception.BaseException;
import com.testpro.data.faceImage.bean.FaceImage;
import com.testpro.data.faceImage.bean.FaceImageSearch;
import com.testpro.data.faceImage.service.spi.IFaceImageService;

/**
 * FaceImage JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author lubo
 * @date 2018-7-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class FaceImageTest {
	@Autowired
	private IFaceImageService faceImageService;
	
	@Test
	public void find() {
		FaceImage s = faceImageService.find(FaceImage.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<FaceImage> list = faceImageService.queryAll(FaceImage.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			FaceImage entity = new FaceImage();
			entity.setId(1);
			faceImageService.save(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		FaceImage entity = new FaceImage();
		entity.setId(1);
		faceImageService.update(entity);
	}
	
	@Test
	public void page() {
		FaceImageSearch search = new FaceImageSearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<FaceImage> list = faceImageService.page(FaceImage.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (FaceImage s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		faceImageService.delete(FaceImage.class, 1);
		// faceImageService.deleteByIds(FaceImage.class, new Object[]{3,5,9});
	}
	
}
