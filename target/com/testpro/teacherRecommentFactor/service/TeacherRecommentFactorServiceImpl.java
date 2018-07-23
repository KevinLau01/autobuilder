package com.testpro.teacherRecommentFactor.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.teacherRecommentFactor.service.spi.ITeacherRecommentFactorService;

/**
 * Service Implementation:TeacherRecommentFactor
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class TeacherRecommentFactorServiceImpl extends MyBatisServiceSupport implements ITeacherRecommentFactorService {
	
}
