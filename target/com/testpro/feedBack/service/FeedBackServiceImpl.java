package com.testpro.feedBack.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.feedBack.service.spi.IFeedBackService;

/**
 * Service Implementation:FeedBack
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class FeedBackServiceImpl extends MyBatisServiceSupport implements IFeedBackService {
	
}
