package com.example.tom.foodbook.Entity;

public class Food {

    private int id;
    private String name;
    private double price;
    private int calories;
    private int proteins;
    private int fats;
    private int sugar;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private int canteenId;
    private int imageId;
    private boolean markFlag;

    public Food(int id, String name, double price, int calories, int proteins, int fats, int sugar, boolean vegetarian, boolean vegan, boolean glutenFree, int canteenId, int imageId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sugar = sugar;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.canteenId = canteenId;
        this.imageId = imageId;
    }

    public Food(String name, double price, int calories, int proteins, int fats, int sugar) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sugar = sugar;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public int getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(int canteenId) {
        this.canteenId = canteenId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isMarkFlag() {
        return markFlag;
    }

    public void setMarkFlag(boolean markFlag) {
        this.markFlag = markFlag;
    }
}
