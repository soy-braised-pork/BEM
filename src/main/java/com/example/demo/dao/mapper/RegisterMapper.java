package com.example.demo.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * @author zhaohan
 **/

@Repository
@MapperScan
public interface RegisterMapper {

    /**
     * 注册用户
     * @param operatorId
     * @param password
     * @return
     */
    @Insert(value = "INSERT INTO operator_menu (user_name ,o_password,o_role) VALUES (#{operatorId},#{password},#{role})")
    Long insertOperator(@Param("operatorId") String operatorId,@Param("password") String password,@Param("role")String role);

}

