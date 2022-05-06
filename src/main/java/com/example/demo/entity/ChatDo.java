package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaohan
 **/
@Data
public class ChatDo implements Serializable {

    private String oUserName;
    private String cContext;
    private Integer status;
    private Date gmtCreate;

}

