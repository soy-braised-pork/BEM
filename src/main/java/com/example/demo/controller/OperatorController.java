package com.example.demo.controller;

import com.example.demo.entity.OperatorRequest;
import com.example.demo.service.IOperatorSV;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zlx
 * Creat on 2022-02-14
 */
@CrossOrigin
@RestController
@RequestMapping("/index")
public class OperatorController {

    private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);

    @Autowired
    private IOperatorSV iOperatorSV;

    @ResponseBody
    @RequestMapping("/querySingIn")
    public Map singIn(HttpServletRequest servletRequest, @RequestBody OperatorRequest request) throws Exception {
        Map map = iOperatorSV.checkLogin(request);
        return map;
    }
}

