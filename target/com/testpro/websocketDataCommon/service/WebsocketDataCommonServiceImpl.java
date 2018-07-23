package com.testpro.websocketDataCommon.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.websocketDataCommon.service.spi.IWebsocketDataCommonService;

/**
 * Service Implementation:WebsocketDataCommon
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class WebsocketDataCommonServiceImpl extends MyBatisServiceSupport implements IWebsocketDataCommonService {
	
}
