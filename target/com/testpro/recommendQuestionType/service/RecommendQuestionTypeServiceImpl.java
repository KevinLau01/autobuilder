package com.testpro.recommendQuestionType.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.recommendQuestionType.service.spi.IRecommendQuestionTypeService;

/**
 * Service Implementation:RecommendQuestionType
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class RecommendQuestionTypeServiceImpl extends MyBatisServiceSupport implements IRecommendQuestionTypeService {
	
}
