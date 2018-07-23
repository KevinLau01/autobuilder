package com.testpro.base.organization.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.base.organization.service.spi.IOrganizationService;

/**
 * Service Implementation:Organization
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class OrganizationServiceImpl extends MyBatisServiceSupport implements IOrganizationService {
	
}
