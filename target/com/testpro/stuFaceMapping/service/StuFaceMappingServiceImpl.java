package com.testpro.stuFaceMapping.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.stuFaceMapping.service.spi.IStuFaceMappingService;

/**
 * Service Implementation:StuFaceMapping
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuFaceMappingServiceImpl extends MyBatisServiceSupport implements IStuFaceMappingService {
	
}
