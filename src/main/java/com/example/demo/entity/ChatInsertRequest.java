package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 **/
@Data
public class ChatInsertRequest implements Serializable {

    private String userName;
    private String context;

}

