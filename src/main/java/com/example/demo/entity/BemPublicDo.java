package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaohan
 **/
@Data
public class BemPublicDo implements Serializable {

    private String pcontext;
    private Integer status;
    private Date gmtCreate;

}

