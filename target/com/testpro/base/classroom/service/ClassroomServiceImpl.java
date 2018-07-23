package com.testpro.base.classroom.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.classroom.service.spi.IClassroomService;

/**
 * Service Implementation:Classroom
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class ClassroomServiceImpl extends MyBatisServiceSupport implements IClassroomService {
	
}
