package com.testpro.data.stuFocus.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.stuFocus.service.spi.IStuFocusService;

/**
 * Service Implementation:StuFocus
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuFocusServiceImpl extends MyBatisServiceSupport implements IStuFocusService {
	
}
