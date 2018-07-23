package com.testpro.base.client.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.client.service.spi.IClientService;

/**
 * Service Implementation:Client
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class ClientServiceImpl extends MyBatisServiceSupport implements IClientService {
	
}
