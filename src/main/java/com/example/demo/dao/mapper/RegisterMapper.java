package com.example.demo.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * @author zhaohan
 **/

@Repository
@MapperScan
@Configuration
public interface RegisterMapper {

    /**
     * 注册用户
     * @param operatorId
     * @param password
     * @return
     */
    @Insert(value = "INSERT INTO operator_menu (operator_id ,password) VALUES (#{operatorId},#{password})")
    Long insertOperator(@Param("operatorId") int operatorId,@Param("password") int password);

}

