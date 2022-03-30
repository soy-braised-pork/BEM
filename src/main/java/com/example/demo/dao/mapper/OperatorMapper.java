package com.example.demo.dao.mapper;

import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.PersonDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Repository
@MapperScan
@Configuration
public interface OperatorMapper{


    @Select(value = "SELECT * FROM operator_menu WHERE operator_id=#{personId}")
    OperatorDao findByPersonId(@Param("personId") String personId);

}
