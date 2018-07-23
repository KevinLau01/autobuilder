package com.testpro.data.postvideo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.postvideo.service.spi.IPostvideoService;

/**
 * Service Implementation:Postvideo
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class PostvideoServiceImpl extends MyBatisServiceSupport implements IPostvideoService {
	
}
