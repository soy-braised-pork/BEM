package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaohan
 **/

@Data
public class RegisterRequest implements Serializable {

    private String userName;
    private String password;
    private String rePassword;
    private String role;

}

