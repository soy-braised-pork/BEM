package com.example.demo.controller;

import com.example.demo.entity.BemPageRequest;
import com.example.demo.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/person")
    public Map searchPerson(HttpServletRequest servletRequest, @RequestBody String personName){
        Map map = searchService.searchPerson(personName);
        return map;
    }

    @PostMapping("/bemPage")
    public Map bemPage(HttpServletRequest servletRequest, @RequestBody BemPageRequest request){
        Map map = searchService.bemPage(request);
        return map;
    }

}

