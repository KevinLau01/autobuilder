package com.testpro.remarkWord.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.remarkWord.service.spi.IRemarkWordService;

/**
 * Service Implementation:RemarkWord
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class RemarkWordServiceImpl extends MyBatisServiceSupport implements IRemarkWordService {
	
}
