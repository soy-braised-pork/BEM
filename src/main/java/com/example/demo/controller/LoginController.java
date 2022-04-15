package com.example.demo.controller;

import com.example.demo.entity.RegisterRequest;
import com.example.demo.service.impl.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginImpl login;

    @PostMapping("/updatePassword")
    public Map updatePassword(HttpServletRequest servletRequest, RegisterRequest request) {
        Map map = login.updatePassword(request);
        return map;
    }

}

