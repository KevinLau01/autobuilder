package com.testpro.data.stuReport.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.stuReport.service.spi.IStuReportService;

/**
 * Service Implementation:StuReport
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class StuReportServiceImpl extends MyBatisServiceSupport implements IStuReportService {
	
}
