package com.example.demo.dao.mapper;

import com.example.demo.entity.BemMenuDo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaohan
 **/
@Repository
@MapperScan
public interface TaskMapper {

    /**
     * 查找所有的bem_menu数据
     * @return
     */
    @Select(value = "SELECT * FROM bem_menu WHERE status=0")
    List<BemMenuDo> getBemMenu();

    /**
     * 假删除所有数据
     * @return
     */
    @Update(value = "UPDATE bem_menu SET status=1")
    Long updateBemMenu();

}

