package com.buildepidemicmonitoring.demo.entry;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Person implements Serializable {


    private static final long serialVersionUID = 4148531456699812439L;

    private int areaId;    //摄像头ID：指明摄像头所在地址
    MultipartFile image;   // 图片
    private float temperature;    //实时温度


    public int getId() {
        return areaId;
    }

    public void setId(int id) {
        this.areaId = id;
    }


    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
