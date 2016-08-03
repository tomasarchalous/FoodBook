package com.example.tom.foodbook;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.tom.foodbook.Entity.Canteen;
import com.example.tom.foodbook.Entity.Food;

import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvHelper {
    AssetManager mngr;
    Context myContext;

    public CsvHelper(Context myContext) {
        mngr = myContext.getAssets();
        this.myContext = myContext;
    }

    /**
     * Returns Arraylist of models of canteens saved in canteen.csv
     *
     * @return ArrayList<Canteen>
     */
    public ArrayList<Canteen> getCanteens() {
        ArrayList<Canteen> canteens = new ArrayList<>();
        try {
            CsvReader products = new CsvReader(new InputStreamReader(myContext.getAssets().open("canteen.csv")));
            products.readHeaders();

            while (products.readRecord()) {
                int id = Integer.parseInt(products.get("id"));
                String name = products.get("name");
                double latitude = Double.parseDouble(products.get("latitude"));
                double longitude = Double.parseDouble(products.get("longitude"));
                String building = products.get("building");
                String description = products.get("description");

                Canteen canteen = new Canteen(id, name, latitude, longitude, building, description);
                canteens.add(canteen);
            }
            products.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return canteens;
    }

    /**
     * Returns Arraylist of models of foods saved in food.csv
     *
     * @return ArrayList<Food>
     */
    public ArrayList<Food> getFoods() {
        ArrayList<Food> foods = new ArrayList<>();
        try {
            CsvReader products = new CsvReader(new InputStreamReader(myContext.getAssets().open("food.csv")));
            products.readHeaders();

            while (products.readRecord()) {
                int id = Integer.parseInt(products.get("id"));
                String name = products.get("name");
                double price = Double.parseDouble(products.get("price"));
                int calories = Integer.parseInt(products.get("calories"));
                int proteins = Integer.parseInt(products.get("proteins"));
                int fats = Integer.parseInt(products.get("fats"));
                int sugar = Integer.parseInt(products.get("sugar"));
                boolean vegetarian = Integer.parseInt(products.get("vegetarian")) == 1 ? true : false;
                boolean vegan = Integer.parseInt(products.get("vegan")) == 1 ? true : false;
                boolean glutenFree = Integer.parseInt(products.get("glutenFree")) == 1 ? true : false;
                int canteenId = Integer.parseInt(products.get("canteenId"));
                // System.out.println(products.get("name") + "Veget" + products.get("vegetarian")+ vegetarian);
                Food food = new Food(id, name, price, calories, proteins, fats, sugar, vegetarian, vegan, glutenFree, canteenId);
                foods.add(food);
            }
            products.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foods;
    }

    /**
     * Returns ArrayList of food served in desired canteen
     *
     * @param canteenId
     * @return
     */
    public ArrayList<Food> getFoodsOfCanteen(int canteenId) {
        ArrayList<Food> foodsOfCanteen = new ArrayList<>();
        ArrayList<Food> allFoods = this.getFoods();

        for (Food food : allFoods) {
            if (food.getCanteenId() == canteenId) {
                foodsOfCanteen.add(food);
            }
        }
        return foodsOfCanteen;
    }

    /**
     * Retirns Canteen by its ID
     *
     * @param id
     * @return
     */
    public Canteen getCanteenByID(int id) {
        Canteen canteen = new Canteen();
        ArrayList<Canteen> canteens = this.getCanteens();

        for (Canteen c : canteens) {
            if (c.getId() == id) {
                canteen = c;
            }
        }

        return canteen;
    }

    /**
     * Returns Food by his ID
     *
     * @param id
     * @return
     */
    public Food getFoodById(int id) {
        Food food = new Food();
        ArrayList<Food> foods = this.getFoods();

        for (Food f : foods) {
            if (f.getId() == id) {
                food = f;
            }
        }
        return food;
    }

}
