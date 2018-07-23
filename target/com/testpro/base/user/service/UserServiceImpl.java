package com.testpro.base.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.user.service.spi.IUserService;

/**
 * Service Implementation:User
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class UserServiceImpl extends MyBatisServiceSupport implements IUserService {
	
}
