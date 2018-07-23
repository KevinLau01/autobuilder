package com.testpro.recommendQuestion.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.recommendQuestion.service.spi.IRecommendQuestionService;

/**
 * Service Implementation:RecommendQuestion
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class RecommendQuestionServiceImpl extends MyBatisServiceSupport implements IRecommendQuestionService {
	
}
