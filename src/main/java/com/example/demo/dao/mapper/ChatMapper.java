package com.example.demo.dao.mapper;

import com.example.demo.entity.ChatDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author zhaohan
 **/
@MapperScan
@Repository
public interface ChatMapper {

    /**
     * 用户新增留言
     * @param userName
     * @param context
     * @param create
     * @return
     */
    @Insert(value = "INSERT INTO bem_chat (o_user_name,c_context,status,gmt_create) VALUES (#{userName},#{context},0,#{create})")
    Long insertChat(@Param("userName") String userName, @Param("context") String context, @Param("create") Date create);

    /**
     * 分页查询留言板
     * @param currPage
     * @param limit
     * @return
     */
    @Select(value = "SELECT * FROM bem_chat LIMIT  #{currPage},#{limit}")
    List<ChatDo> chatPage(@Param("currPage") int currPage,@Param("limit") int limit);

}

