package com.testpro.data.classReport.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.classReport.service.spi.IClassReportService;

/**
 * Service Implementation:ClassReport
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class ClassReportServiceImpl extends MyBatisServiceSupport implements IClassReportService {
	
}
