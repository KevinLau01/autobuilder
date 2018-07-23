package com.testpro.data.fiveFactor.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.fiveFactor.service.spi.IFiveFactorService;

/**
 * Service Implementation:FiveFactor
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class FiveFactorServiceImpl extends MyBatisServiceSupport implements IFiveFactorService {
	
}
