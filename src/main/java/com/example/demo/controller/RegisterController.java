package com.example.demo.controller;

import com.example.demo.entity.RegisterRequest;
import com.example.demo.service.impl.RegisterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhaohan
 **/
@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterImpl registerImpl;

    @PostMapping("/register")
    public Map registerOperator(HttpServletRequest servletRequest, @RequestBody RegisterRequest request) {
        Map map = registerImpl.registerOperator(request);
        return map;
    }

}

