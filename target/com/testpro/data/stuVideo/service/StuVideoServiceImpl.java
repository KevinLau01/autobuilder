package com.testpro.data.stuVideo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.stuVideo.service.spi.IStuVideoService;

/**
 * Service Implementation:StuVideo
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuVideoServiceImpl extends MyBatisServiceSupport implements IStuVideoService {
	
}
