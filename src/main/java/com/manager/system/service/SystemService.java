package com.manager.system.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 系统service
 */
public interface SystemService {

    String upload(MultipartFile file) throws Exception;
}
