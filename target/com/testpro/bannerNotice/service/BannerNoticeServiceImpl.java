package com.testpro.bannerNotice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.bannerNotice.service.spi.IBannerNoticeService;

/**
 * Service Implementation:BannerNotice
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class BannerNoticeServiceImpl extends MyBatisServiceSupport implements IBannerNoticeService {
	
}
