package com.example.demo.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * @author zhaohan
 **/

@Repository
@MapperScan
@Configuration
public interface LoginMapper {

    /**
     * 修改密码
     * @param userName
     * @param password
     * @return
     */
    @Update(value = "UPDATE operator_menu SET password=#{password} WHERE user_name=#{userName}")
    Long updatePassword(@Param("userName") String userName,@Param("password") String password);

}

