package com.testpro.logOperation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.logOperation.service.spi.ILogOperationService;

/**
 * Service Implementation:LogOperation
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class LogOperationServiceImpl extends MyBatisServiceSupport implements ILogOperationService {
	
}
