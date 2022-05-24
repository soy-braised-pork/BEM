package com.example.demo.dao.mapper;

import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.entity.OperatorDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * @author zlx
 * @date 2022-04-13
 */

@Repository
@MapperScan
@Configuration
public interface OperatorMapper{

    @Select(value = "SELECT * FROM operator_menu WHERE user_name=#{userName}")
    OperatorDO findByPersonId(@Param("userName") String userName);

}
