package com.example.demo.service.impl;

import com.example.demo.dao.mapper.SearchMapper;
import com.example.demo.entity.BemMenuDo;
import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.SearchRequest;
import com.example.demo.entity.SysRequest;
import com.example.demo.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
            map.put("success","false");
            map.put("body", null);
            return map;
        }
        if ("".equals(request.getPersonName())){
            List<BemMenuDo> dos = searchMapper.searchAll();
            map.put("errorCode", null);
            map.put("success","true");
            map.put("body", dos);
            return map;
        }
        List<BemMenuDo> dos = searchMapper.searchPerson(request.getPersonName());
        map.put("errorCode", null);
        map.put("success","true");
        map.put("body", dos);
        return map;
    }

    @Override
    public Map bemPage(BemPageRequest request) {
        HashMap map = new HashMap<>();
        if (request == null){
            map.put("errorCode ", "入参不能为空");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
        int currPage;
        currPage= (request.getCurrPage()-1)* request.getLimit();
        List<BemMenuDo> dos = searchMapper.bemPage(currPage, request.getLimit());
        map.put("errorCode", null);
        map.put("success","true");
        map.put("body", dos);
        return map;
    }

    @Override
    public Map searchSys(SysRequest request) {
        HashMap map = new HashMap<>();
        if (request==null){
            map.put("errorCode", "入参不能为空");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
        if ("".equals(request.getSysId())){
            List<BemMenuDo> dos = searchMapper.searchAll();
            map.put("errorCode", null);
            map.put("success","true");
            map.put("body", dos);
            return map;
        }
        List<BemMenuDo> dos = searchMapper.searchSys(request.getSysId());
        map.put("errorCode", null);
        map.put("success","true");
        map.put("body", dos);
        return map;
    }

}

