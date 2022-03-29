package com.example.demo.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.PersonDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */
@Service
public interface IOperatorSV {


    /**
     * 验证用户名密码
     */
    PersonDao checkLogin(String personId, String pwd) throws Exception;

    /**
     * 查询用户信息
     */
    List<PersonDao> getOperator();
}
