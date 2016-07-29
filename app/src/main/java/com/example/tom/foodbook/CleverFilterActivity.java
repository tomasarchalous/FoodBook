package com.example.tom.foodbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tom.foodbook.Adapter.OfferFoodAdapter;
import com.example.tom.foodbook.Entity.Food;

import java.util.ArrayList;

/**
 * Created by Mira on 29.7.2016.
 */
public class CleverFilterActivity extends AppCompatActivity {

    public static final String MIBA_TAG = "MIBA_TAG";

    private ArrayList<Food> offerFoodList;
    private RecyclerView rvOfferFood;
    private RecyclerView.LayoutManager offerFoodLayoutManager;
    private OfferFoodAdapter offerFoodAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clever_filter);

        /* ************************************************************************************** */

        //RecyclerView.ItemDecoration itemDecoration
        rvOfferFood = (RecyclerView) findViewById(R.id.rv_offer_food);
        rvOfferFood.setHasFixedSize(true);
        offerFoodLayoutManager = new LinearLayoutManager(this);
        rvOfferFood.setLayoutManager(offerFoodLayoutManager);

        /* ************************************************************************************** */

        Food food1 = new Food("noodle_wagon");
        Food food2 = new Food("scrambled_eggs");

        offerFoodList = new ArrayList<>();
        offerFoodList.add(food1);
        offerFoodList.add(food2);

        offerFoodAdapter = new OfferFoodAdapter(offerFoodList);
        rvOfferFood.setAdapter(offerFoodAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MIBA_TAG, "CleverFilterActivity START");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MIBA_TAG, "CleverFilterActivity STOP");
    }
}
