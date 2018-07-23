package com.testpro.data.stuImage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.stuImage.service.spi.IStuImageService;

/**
 * Service Implementation:StuImage
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuImageServiceImpl extends MyBatisServiceSupport implements IStuImageService {
	
}
