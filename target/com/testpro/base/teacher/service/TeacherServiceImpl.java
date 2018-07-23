package com.testpro.base.teacher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.teacher.service.spi.ITeacherService;

/**
 * Service Implementation:Teacher
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class TeacherServiceImpl extends MyBatisServiceSupport implements ITeacherService {
	
}
