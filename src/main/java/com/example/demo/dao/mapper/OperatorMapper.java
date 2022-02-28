package com.example.demo.dao.mapper;

import com.example.demo.dao.PersonDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Repository
@MapperScan
@Configuration
public interface OperatorMapper{

    PersonDao findByPersonId(String personId);

}
