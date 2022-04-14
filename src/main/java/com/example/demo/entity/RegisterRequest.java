package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 **/

@Data
public class RegisterRequest implements Serializable {

    private int userName;
    private int password;
    private int rePassword;

}

