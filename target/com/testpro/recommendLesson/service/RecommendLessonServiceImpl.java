package com.testpro.recommendLesson.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.recommendLesson.service.spi.IRecommendLessonService;

/**
 * Service Implementation:RecommendLesson
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class RecommendLessonServiceImpl extends MyBatisServiceSupport implements IRecommendLessonService {
	
}
