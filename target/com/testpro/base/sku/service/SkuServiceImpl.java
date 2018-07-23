package com.testpro.base.sku.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.sku.service.spi.ISkuService;

/**
 * Service Implementation:Sku
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class SkuServiceImpl extends MyBatisServiceSupport implements ISkuService {
	
}
