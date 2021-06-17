package com.example.realestate;

public class dummyData {

    public int projectID;
    public int image;
    public String price;
    public String name;
    public String place;
    public String description;
    public String agent;
    public String number;

    public dummyData(int projectID, int image,
            String price,
            String name,
            String place,
            String description,
            String agent,
            String number){

        this.projectID = projectID;
        this.image = image;
        this.price = price;
        this.name = name;
        this.place = place;
        this.description = description;
        this.agent = agent;
        this.number = number;
    }

    public int getImage() {
        return image;
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
}
