package com.testpro.base.course.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.course.service.spi.ICourseService;

/**
 * Service Implementation:Course
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class CourseServiceImpl extends MyBatisServiceSupport implements ICourseService {
	
}
