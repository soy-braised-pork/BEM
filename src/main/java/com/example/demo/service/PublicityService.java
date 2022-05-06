package com.example.demo.service;

import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.PublicityRequest;

import java.util.Map;

/**
 * @author zhaohan
 **/
public interface PublicityService {

    /**
     * 写入公告
     * @param request
     * @return
     */
    Map insertPublicity(PublicityRequest request);

    /**
     * 查看公告
     * @param request
     * @return
     */
    Map publicityPage(BemPageRequest request);

}

