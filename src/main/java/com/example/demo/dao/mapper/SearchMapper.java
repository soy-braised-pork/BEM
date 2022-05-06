package com.example.demo.dao.mapper;

import com.example.demo.entity.BemMenuDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaohan
 **/
@MapperScan
@Repository
public interface SearchMapper {

    /**
     * 搜索人的温度列表
     * @param personName
     * @return
     */
    @Select(value = "SELECT * FROM bem_menu WHERE person_name=#{personName}")
    List<BemMenuDo> searchPerson(@Param("personName") String personName);

    /**
     * 分页查询个人信息
     * @param currPage
     * @param limit
     * @return
     */
    @Select(value = "SELECT * FROM bem_menu LIMIT #{currPage},#{limit}")
    List<BemMenuDo> bemPage(@Param("currPage") int currPage,@Param("limit") int limit);

}

