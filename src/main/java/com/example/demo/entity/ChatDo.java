package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 **/
@Data
public class ChatDo implements Serializable {

    private String oUserName;
    private String cContext;
    private Integer status;

}

