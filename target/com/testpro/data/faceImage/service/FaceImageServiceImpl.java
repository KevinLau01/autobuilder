package com.testpro.data.faceImage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testpro.common.service.MyBatisServiceSupport;
import com.testpro.data.faceImage.service.spi.IFaceImageService;

/**
 * Service Implementation:FaceImage
 * @author lubo
 * @date 2018-7-23
 */
@Service
@Transactional
public class FaceImageServiceImpl extends MyBatisServiceSupport implements IFaceImageService {
	
}
