package com.example.tom.foodbook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.foodbook.Adapter.OfferFoodCompactAdapter;
import com.example.tom.foodbook.Entity.Canteen;
import com.example.tom.foodbook.Entity.Food;

import java.util.ArrayList;

public class FoodOverviewActivity extends Activity {

    private Food food;
    private CsvHelper csvHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_food_overview);

        Intent intent = getIntent();

        this.csvHelper = new CsvHelper(FoodOverviewActivity.this);
        this.food = csvHelper.getFoodById(intent.getIntExtra("foodId", 666));

//        TextView canteenNo = (TextView) findViewById(R.id.canteenNo);
//        TextView descriptionOfCanteen = (TextView) findViewById(R.id.descriptionOfCanteen);
//        TextView tv_building_name = (TextView) findViewById(R.id.tv_building_name);

        ImageView iv_image = (ImageView) findViewById(R.id.iv_image);
        TextView tv_food_name = (TextView) findViewById(R.id.tv_food_name);
        TextView tv_food_price = (TextView) findViewById(R.id.tv_food_price);
        TextView tv_food_calories = (TextView) findViewById(R.id.tv_food_calories);
        TextView tv_food_fats = (TextView) findViewById(R.id.tv_food_fats);
        TextView tv_food_proteins = (TextView) findViewById(R.id.tv_food_proteins);
        TextView tv_food_sugar = (TextView) findViewById(R.id.tv_food_sugar);
        TextView tv_food_vegetarian = (TextView) findViewById(R.id.tv_food_vegetarian);
        TextView tv_food_vegan = (TextView) findViewById(R.id.tv_food_vegan);
        TextView tv_food_gluten_free = (TextView) findViewById(R.id.tv_food_gluten_free);

        iv_image.setImageResource(food.getImageResource(FoodOverviewActivity.this));
        tv_food_name.setText(food.getName());
        tv_food_price.setText("Price: "+String.valueOf(food.getPrice())+ "HK$");
        tv_food_calories.setText("Calories: "+String.valueOf(food.getCalories())+"kCal");
        tv_food_fats.setText("Fats: "+String.valueOf(food.getFats())+"g");
        tv_food_proteins.setText("Proteins: "+String.valueOf(food.getProteins())+"g");
        tv_food_sugar.setText("Sugar: "+String.valueOf(food.getSugar())+"g");
        tv_food_vegetarian.setText("Vegetarian: " + (food.isVegetarian() ? "Yes" : "No"));
        tv_food_vegan.setText("Vegan: " + (food.isVegan() ? "Yes" : "No"));
        tv_food_gluten_free.setText("Gluten free: " + (food.isGlutenFree() ? "Yes" : "No"));


//        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/blokletters_balpen.ttf");
//        canteenNo.setTypeface(tf, Typeface.NORMAL);
//        canteenNo.setText("Canteen name: " + canteen.getName());


    }
}
