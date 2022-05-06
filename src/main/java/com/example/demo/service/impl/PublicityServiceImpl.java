package com.example.demo.service.impl;

import com.example.demo.dao.mapper.PublicityMapper;
import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.BemPublicDo;
import com.example.demo.entity.PublicityRequest;
import com.example.demo.service.PublicityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@Service
public class PublicityServiceImpl implements PublicityService {

    @Autowired
    private PublicityMapper publicityMapper;

    @Override
    public Map insertPublicity(PublicityRequest request) {
        HashMap map = new HashMap<>();
        if (request == null && StringUtils.isEmpty(request.getContext())){
            map.put("errorCode ", "入参不能为空");
            return map;
        }
        Long aLong = publicityMapper.insertPublicity(request.getContext(),new Date());
        if (aLong < 0L){
            map.put("errorCode ", "录入失败");
            return map;
        }
        map.put("errorCode", "success");
        map.put("body", "录入成功");
        return map;
    }

    @Override
    public Map publicityPage(BemPageRequest request) {
        HashMap map = new HashMap<>();
        if (request == null){
            map.put("errorCode ", "入参不能为空");
            return map;
        }
        List<BemPublicDo> dos = publicityMapper.publicityPage(request.getCurrPage(), request.getLimit());
        map.put("errorCode", "success");
        map.put("body", dos);
        return map;
    }

}

