package com.example.tom.foodbook;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import java.io.FileReader;
import java.io.InputStream;
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

                Canteen canteen = new Canteen(id, name);
                canteens.add(canteen);

                System.out.println(id + ":" + name);
            }

            products.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return canteens;
    }

    /**
     * Returns Arraylist of models of foods saved in food.csv
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

                Food food = new Food(id, name, price);
                foods.add(food);

                System.out.println(id + ":" + name + price);
            }

            products.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return foods;
    }
}
