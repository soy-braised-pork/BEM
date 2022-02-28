package com.example.demo.service.impl;

import com.example.demo.dao.mapper.OperatorMapper;
import com.example.demo.dao.PersonDao;
import com.example.demo.service.IOperatorSV;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zlx
 * Creat on 2022-02-14
 */
@Slf4j
@Service
public class OperatorImpl implements IOperatorSV {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public PersonDao checkLogin(String personId, String pwd) throws Exception {
        //校验用户名是否存在
        //拿用户名查询
        PersonDao operatorDao = operatorMapper.findByPersonId(personId);
        if ("".equals(personId)) {
            throw new Exception("登录名不能为空");
        } else {
            if (operatorDao == null) {
                throw new Exception("用户名不存在");
            } else {
                //用户名拿到密码，是否与入参一致
                //拿到密码
//                if (!operatorDao.getPassword().equals(pwd.trim())){
//                    throw new Exception("密码错误");
//                }
            }
        }
        return operatorDao;
    }

    @Override
    public List<PersonDao> getOperator() {
        return null;
    }
}
