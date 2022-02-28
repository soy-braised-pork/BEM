package com.example.demo.dao;

/**
 * @author zlx
 * Creat on 2022-01-17
 */

public class PersonDao {
    private int sysId; //摄像机ID
    private String personId; //人员ID
    private float personTemp; //人员温度
    private String personPictureURL; //人员抓拍照片
    private boolean isPlace; //是否是风险地区


    public int getSysId() {
        return sysId;
    }

    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public float getPersonTemp() {
        return personTemp;
    }

    public void setPersonTemp(float personTemp) {
        this.personTemp = personTemp;
    }

    public String getPersonPictureURL() {
        return personPictureURL;
    }

    public void setPersonPictureURL(String personPictureURL) {
        this.personPictureURL = personPictureURL;
    }

    public boolean isPlace() {
        return isPlace;
    }

    public void setPlace(boolean place) {
        isPlace = place;
    }


    public PersonDao() {
        //空构造器
    }



}
