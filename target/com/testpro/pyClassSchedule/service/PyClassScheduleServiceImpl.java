package com.testpro.pyClassSchedule.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.pyClassSchedule.service.spi.IPyClassScheduleService;

/**
 * Service Implementation:PyClassSchedule
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class PyClassScheduleServiceImpl extends MyBatisServiceSupport implements IPyClassScheduleService {
	
}
