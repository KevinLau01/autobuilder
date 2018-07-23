package com.testpro.feedImpress.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.feedImpress.service.spi.IFeedImpressService;

/**
 * Service Implementation:FeedImpress
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class FeedImpressServiceImpl extends MyBatisServiceSupport implements IFeedImpressService {
	
}
