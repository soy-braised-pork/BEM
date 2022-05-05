package com.example.demo.dao.mapper;

import com.example.demo.entity.BemPublicDo;
import org.apache.ibatis.annotations.Insert;
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
public interface PublicityMapper {

    /**
     * 写入公告
     * @param context
     * @return
     */
    @Insert(value = "INSERT INTO bem_public (p_context,status) VALUES (#{context},0)")
    Long insertPublicity(@Param("context") String context);

    /**
     * 查看公告
     * @param currPage
     * @param limit
     * @return
     */
    @Select(value = "SELECT * FROM bem_chat LIMIT  #{currPage},#{limit}")
    List<BemPublicDo> publicityPage(@Param("currPage") int currPage,@Param("limit") int limit);

}

