package com.testpro.base.class.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.class.service.spi.IClassService;

/**
 * Service Implementation:Class
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class ClassServiceImpl extends MyBatisServiceSupport implements IClassService {
	
}
