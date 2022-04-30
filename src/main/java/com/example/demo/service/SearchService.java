package com.example.demo.service;

import com.example.demo.entity.BemMenuDo;
import com.example.demo.entity.BemPageRequest;

import java.util.List;
import java.util.Map;

/**
 * @author zhaohan
 **/
public interface SearchService {

    /**
     * 搜索个人的信息列表
     * @param personName
     * @return
     */
    Map searchPerson(String personName);

    /**
     * 分页查询个人信息
     * @param request
     * @return
     */
    Map bemPage(BemPageRequest request);

}

