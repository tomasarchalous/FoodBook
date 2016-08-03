package com.example.tom.foodbook.Entity;

/**
 * Created by Mira on 2.8.2016.
 */
public class NutritionValue {

    private String name;
    private float value;

    public NutritionValue(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
