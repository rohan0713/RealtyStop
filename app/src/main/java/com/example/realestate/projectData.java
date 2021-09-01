package com.example.realestate;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "projects")
public class projectData implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int projectID;
    public String price;
    public String name;
    public String place;
    public String description;
    public String agent;
    public String number;
    public String address;
    public String image;
    public String type;

    public projectData(int projectID,
                       String price,
                       String name,
                       String place,
                       String description,
                       String agent,
                       String number,
                       String address,
                       String image,
                       String type){

        this.projectID = projectID;
        this.price = price;
        this.name = name;
        this.place = place;
        this.description = description;
        this.agent = agent;
        this.number = number;
        this.address = address;
        this.image = image;
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public String getAgent() {
        return agent;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress(){ return address;}

    public String getImage(){ return image; }

    public String getType(){ return type; }
}
