package com.testpro.base.stu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.stu.service.spi.IStuService;

/**
 * Service Implementation:Stu
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuServiceImpl extends MyBatisServiceSupport implements IStuService {
	
}
