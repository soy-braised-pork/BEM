package com.example.demo.service;

import com.example.demo.entity.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhaohan
 **/
@Service
public interface RegisterService {

    /**
     * 注册用户
     * @param request
     * @return
     */
    Map registerOperator(RegisterRequest request);

}

