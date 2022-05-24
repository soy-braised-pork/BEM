package com.example.demo.service.impl;

import com.example.demo.dao.mapper.SearchMapper;
import com.example.demo.entity.BemMenuDo;
import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.SearchRequest;
import com.example.demo.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public Map searchPerson(SearchRequest request) {
        HashMap map = new HashMap<>();
        if (request == null) {
            map.put("errorCode ", "入参不能为空");
            return map;
        }
        List<BemMenuDo> dos = searchMapper.searchPerson(request.getPersonName());
        map.put("errorCode", "success");
        map.put("body", dos);
        return map;
    }

    @Override
    public Map bemPage(BemPageRequest request) {
        HashMap map = new HashMap<>();
        if (request == null){
            map.put("errorCode ", "入参不能为空");
            return map;
        }
        int currPage;
        currPage= request.getCurrPage()* request.getLimit();
        List<BemMenuDo> dos = searchMapper.bemPage(currPage, request.getLimit());
        map.put("errorCode", "success");
        map.put("body", dos);
        return map;
    }

}

