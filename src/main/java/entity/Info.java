package entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Info implements Serializable {

    private static final long serialVersionUID = -6154241154676769466L;

    private int id;  //摄像头ID：指明摄像头所在地址
    MultipartFile image; // 图片
    private float temperature;    //实时温度


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }



    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
