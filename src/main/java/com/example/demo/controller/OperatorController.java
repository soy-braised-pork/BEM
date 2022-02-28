package com.example.demo.controller;

import com.example.demo.service.IOperatorSV;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zlx
 * Creat on 2022-02-14
 */
@Controller
@RequestMapping("/index")
public class OperatorController {

    private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);

    @Autowired
    IOperatorSV iOperatorSV;

    @ResponseBody
    @RequestMapping("/querySingIn")
    public Map singIn(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("--------------------用户登录--------------------");

        Map map = new HashMap<>();
        try {
            String personId = request.getParameter("personId").trim();
            String pwd = request.getParameter("pwd").trim();
            if (StringUtils.isBlank(personId) || StringUtils.isBlank(pwd)) {
                map.put("result", "error");
                map.put("errorMsg", "用户名密码不能为空!");
                logger.info("用户名密码不能为空!");
                return map;
            }
            logger.info("入参: 姓名-->{}  密码-->{}", personId, pwd);

            //验证码
            String code=request.getParameter("verifyCode");
            if (StringUtils.isBlank(code)){
                map.put("result", "error");
                map.put("errorMsg", "验证码不能为空!");
                logger.info("验证码不能为空!");
            }else {
                String sCode= (String) request.getSession().getAttribute("codeValidate");
                if (StringUtils.isBlank(sCode)||!sCode.equalsIgnoreCase(code)){
                    map.put("result", "error");
                    map.put("errorMsg", "验证码有误!");
                    logger.info("验证码有误!");
                }
            }

            Map queryNamePwd = (Map) iOperatorSV.checkLogin(personId, pwd);

            map.put("queryWarePlanMap", queryNamePwd);
            map.put("result", "success");
            map.put("successMsg", "查询成功!");

            if ("admin".equals(personId)) {
                response.getWriter().print("true");
            }
        } catch (Exception e) {
            map.put("result", "error");
//            map.put("errorMsg", "查询失败!");
            map.put("errorMsg", e.getMessage());
            logger.error("{}->查询结果:查询管理员表失败。", e);
        }
        logger.debug("-------------用户登录结束-------------");
        return map;
    }
}

