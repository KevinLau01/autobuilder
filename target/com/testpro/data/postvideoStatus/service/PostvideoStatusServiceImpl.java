package com.testpro.data.postvideoStatus.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.postvideoStatus.service.spi.IPostvideoStatusService;

/**
 * Service Implementation:PostvideoStatus
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class PostvideoStatusServiceImpl extends MyBatisServiceSupport implements IPostvideoStatusService {
	
}
