package com.testpro.base.stuClassMapping.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.stuClassMapping.service.spi.IStuClassMappingService;

/**
 * Service Implementation:StuClassMapping
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuClassMappingServiceImpl extends MyBatisServiceSupport implements IStuClassMappingService {
	
}
