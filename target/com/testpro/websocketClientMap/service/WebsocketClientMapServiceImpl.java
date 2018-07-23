package com.testpro.websocketClientMap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.websocketClientMap.service.spi.IWebsocketClientMapService;

/**
 * Service Implementation:WebsocketClientMap
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class WebsocketClientMapServiceImpl extends MyBatisServiceSupport implements IWebsocketClientMapService {
	
}
