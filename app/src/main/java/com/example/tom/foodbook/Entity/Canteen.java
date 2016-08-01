package com.example.tom.foodbook.Entity;

import android.content.Context;

public class Canteen {

    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private String building;
    private String description;
    public static final String IMAGE_PREFIX = "canteen_";

    public Canteen() {
    }

    public Canteen(int id, String name, double latitude, double longitude, String building, String description) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.building = building;
        this.description = description;
    }

    public int getImageResource(Context mContext){
        String uri = "@drawable/" + IMAGE_PREFIX + this.getId();
        int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());

        if ( imageResource == 0 ) {
            uri = "@drawable/photo_not_available";
            imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());

        }

        return imageResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
