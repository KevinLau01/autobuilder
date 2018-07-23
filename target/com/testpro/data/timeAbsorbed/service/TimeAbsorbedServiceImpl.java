package com.testpro.data.timeAbsorbed.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.timeAbsorbed.service.spi.ITimeAbsorbedService;

/**
 * Service Implementation:TimeAbsorbed
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class TimeAbsorbedServiceImpl extends MyBatisServiceSupport implements ITimeAbsorbedService {
	
}
