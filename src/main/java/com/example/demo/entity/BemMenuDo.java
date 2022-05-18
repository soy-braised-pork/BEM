package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaohan
 **/
@Data
public class BemMenuDo implements Serializable {

    private Long id;
    private Long sysId;
    private String personName;
    private Double personTemp;
    private String personPicture;
    private Integer status;
    private Date gmtCreate;

}

