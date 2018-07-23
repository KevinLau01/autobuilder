package com.testpro.data.classFocus.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.classFocus.service.spi.IClassFocusService;

/**
 * Service Implementation:ClassFocus
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class ClassFocusServiceImpl extends MyBatisServiceSupport implements IClassFocusService {
	
}
