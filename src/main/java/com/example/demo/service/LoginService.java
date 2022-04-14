package com.example.demo.service;

import com.example.demo.entity.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhaohan
 **/
@Service
public interface LoginService {

    /**
     * 修改密码
     * @param request
     * @return
     */
    Map updatePassword(RegisterRequest request);

}
