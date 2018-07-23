package com.testpro.data.userDimension.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.userDimension.service.spi.IUserDimensionService;

/**
 * Service Implementation:UserDimension
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class UserDimensionServiceImpl extends MyBatisServiceSupport implements IUserDimensionService {
	
}
