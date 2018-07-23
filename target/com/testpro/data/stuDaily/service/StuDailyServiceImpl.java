package com.testpro.data.stuDaily.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.stuDaily.service.spi.IStuDailyService;

/**
 * Service Implementation:StuDaily
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuDailyServiceImpl extends MyBatisServiceSupport implements IStuDailyService {
	
}
