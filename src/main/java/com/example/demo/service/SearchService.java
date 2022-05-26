package com.example.demo.service;

import com.example.demo.entity.BemMenuDo;
import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.SearchRequest;
import com.example.demo.entity.SysRequest;

import java.util.List;
import java.util.Map;

/**
 * @author zhaohan
 **/
public interface SearchService {

    /**
     * 搜索个人的信息列表
     * @param request
     * @return
     */
    Map searchPerson(SearchRequest request);

    /**
     * 分页查询个人信息
     * @param request
     * @return
     */
    Map bemPage(BemPageRequest request);

    /**
     * 查询摄像头的信息
     * @param request
     * @return
     */
    Map searchSys(SysRequest request);

}

