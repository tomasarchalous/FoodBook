package com.example.tom.foodbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.foodbook.Adapter.OfferFoodCompactAdapter;
import com.example.tom.foodbook.Entity.Canteen;
import com.example.tom.foodbook.Entity.Food;

import java.util.ArrayList;

public class FoodOverviewActivity extends AppCompatActivity {

    private Food food;
    private CsvHelper csvHelper;

    public static final String MIBA_TAG = "MIBA_TAG";

    private ArrayList<Food> offerFoodList;
    private RecyclerView rvOfferFood;
    private RecyclerView.LayoutManager offerFoodLayoutManager;
    private OfferFoodCompactAdapter offerFoodAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_overview);

        Intent intent = getIntent();
//
        this.csvHelper = new CsvHelper(FoodOverviewActivity.this);
        this.food = csvHelper.getFoodById(intent.getIntExtra("foodId", 666));
//
//        TextView canteenNo = (TextView) findViewById(R.id.canteenNo);
//        TextView descriptionOfCanteen = (TextView) findViewById(R.id.descriptionOfCanteen);
//        TextView tv_building_name = (TextView) findViewById(R.id.tv_building_name);
//
        ImageView iv_image = (ImageView) findViewById(R.id.iv_image);

        iv_image.setImageResource(food.getImageResource(FoodOverviewActivity.this));

//        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/blokletters_balpen.ttf");
//        canteenNo.setTypeface(tf, Typeface.NORMAL);
//        canteenNo.setText("Canteen name: " + canteen.getName());


    }
}
