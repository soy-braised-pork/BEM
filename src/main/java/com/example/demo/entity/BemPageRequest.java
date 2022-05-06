package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 **/
@Data
public class BemPageRequest implements Serializable {

    private int limit;
    private int currPage;

}

