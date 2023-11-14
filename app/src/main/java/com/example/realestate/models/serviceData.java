package com.example.realestate.models;

import java.io.Serializable;

public class serviceData implements Serializable {

    public String background_color;
    public String name;
    public int image;

    public serviceData(String color, String name, int image){
        this.background_color = color;
        this.name = name;
        this.image = image;
    }
}
