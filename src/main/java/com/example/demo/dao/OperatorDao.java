package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zlx
 * Creat on 2022-02-14
 */

public class OperatorDao {


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Integer personId; //管理员id
    private String password; //密码



    public OperatorDao() {
        //构造器
        List list = new List;
    }
}
