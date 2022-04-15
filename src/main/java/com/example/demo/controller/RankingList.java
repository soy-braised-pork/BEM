package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计排行榜
 * @author zlx
 * Creat on 2022-04-13
 */
public class RankingList {
    private static final Logger logger = LoggerFactory.getLogger(RankingList.class);

    @ResponseBody
    @RequestMapping("/showRank")
    public Map ShowRank(HttpServletRequest request, HttpServletResponse response) {
        HashMap<Object, Object> result = new HashMap<>();
        try {
            String rankankListTatol="";

        }catch (Exception e){
            result.put("error","error");
            logger.error("获取排行榜失败",e);
        }
        return result;
    }

}
