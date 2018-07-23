package com.testpro.data.timeEmotion.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.timeEmotion.service.spi.ITimeEmotionService;

/**
 * Service Implementation:TimeEmotion
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class TimeEmotionServiceImpl extends MyBatisServiceSupport implements ITimeEmotionService {
	
}
