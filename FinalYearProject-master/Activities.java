package com.example.finalyearproject;

public class Activities {

    int image;
    String name,area,description;

    public Activities(int image, String name, String area, String description) {
        this.image = image;
        this.name = name;
        this.area = area;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getDescription() {
        return description;
    }
}
