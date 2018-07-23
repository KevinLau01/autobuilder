package com.testpro.remarkChange.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.remarkChange.service.spi.IRemarkChangeService;

/**
 * Service Implementation:RemarkChange
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class RemarkChangeServiceImpl extends MyBatisServiceSupport implements IRemarkChangeService {
	
}
