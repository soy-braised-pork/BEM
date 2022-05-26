package com.example.demo.controller;

import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.PublicityRequest;
import com.example.demo.service.impl.PublicityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/publicity")
public class PublicityController {

    @Autowired
    private PublicityServiceImpl publicityService;

    @PostMapping("/insert")
    public Map insertPublicity(HttpServletRequest servletRequest, @RequestBody PublicityRequest request){
        Map map = publicityService.insertPublicity(request);
        return map;
    }

    @PostMapping("/page")
    public Map publicityPage(HttpServletRequest servletRequest, @RequestBody BemPageRequest request) {
        Map map = publicityService.publicityPage(request);
        return map;
    }

}

