package com.testpro.smsLog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.smsLog.service.spi.ISmsLogService;

/**
 * Service Implementation:SmsLog
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class SmsLogServiceImpl extends MyBatisServiceSupport implements ISmsLogService {
	
}
