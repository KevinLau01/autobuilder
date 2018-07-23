package com.testpro.rulePermission.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.rulePermission.service.spi.IRulePermissionService;

/**
 * Service Implementation:RulePermission
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class RulePermissionServiceImpl extends MyBatisServiceSupport implements IRulePermissionService {
	
}
