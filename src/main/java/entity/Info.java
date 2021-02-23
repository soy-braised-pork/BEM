package entity;

import java.io.Serializable;

public class Info implements Serializable {

    private static final long serialVersionUID = -6154241154676769466L;

    private int id;
    private String place;
    private float temperature;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPlace(){
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
