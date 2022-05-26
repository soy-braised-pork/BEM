package com.example.demo.dao.mapper;

import com.example.demo.entity.OperatorDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.Date;

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
     * @param role
     * @param create
     * @return
     */
    @Insert(value = "INSERT INTO operator_menu (user_name ,o_password,o_role,status,gmt_create) VALUES (#{operatorId},#{password},#{role},0,#{create})")
    Long insertOperator(@Param("operatorId") String operatorId, @Param("password") String password, @Param("role")String role, @Param("create") Date create);

    @Select(value = "SELECT * FROM operator_menu WHERE user_name=#{userName}")
    OperatorDO selectOperator(@Param("userName") String userName);
}

