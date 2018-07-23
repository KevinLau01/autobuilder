package com.testpro.base.city.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.city.service.spi.ICityService;

/**
 * Service Implementation:City
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class CityServiceImpl extends MyBatisServiceSupport implements ICityService {
	
}
