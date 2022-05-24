package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 **/
@Data
public class SearchRequest implements Serializable {

    private String personName;

}
