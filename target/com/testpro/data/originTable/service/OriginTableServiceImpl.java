package com.testpro.data.originTable.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.originTable.service.spi.IOriginTableService;

/**
 * Service Implementation:OriginTable
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class OriginTableServiceImpl extends MyBatisServiceSupport implements IOriginTableService {
	
}
