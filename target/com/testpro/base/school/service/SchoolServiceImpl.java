package com.testpro.base.school.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.school.service.spi.ISchoolService;

/**
 * Service Implementation:School
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class SchoolServiceImpl extends MyBatisServiceSupport implements ISchoolService {
	
}
