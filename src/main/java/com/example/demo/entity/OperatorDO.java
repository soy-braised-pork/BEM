package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhaohan
 **/
@Data
public class OperatorDO implements Serializable {

    private Long id;
    private String userName;
    private String oPassword;
    private String oRole;
    private Integer status;
    private Date gmtCreate;

}
