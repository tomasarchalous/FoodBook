package com.example.tom.foodbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tom.foodbook.Adapter.OfferFoodAdapter;
import com.example.tom.foodbook.Entity.Food;

import java.util.ArrayList;

/**
 * Created by Mira on 29.7.2016.
 */
public class CleverFilterActivity extends AppCompatActivity implements OfferFoodAdapter.ViewHolder.ClickListener {

    public static final String MIBA_TAG = "MIBA_TAG";

    private ArrayList<Food> offerFoodList;
    private RecyclerView rvOfferFood;
    private RecyclerView.LayoutManager offerFoodLayoutManager;
    private OfferFoodAdapter offerFoodAdapter;
    private TextView tvChosenProteins, tvChosenFats, tvChosenSugar, tvGivenProteins, tvGivenFats, tvGivenSugar;

    private int proteinsSum = 0;
    private int fatsSum = 0;
    private int sugarSum = 0;
    private int givenProteins;
    private int givenFats;
    private int givenSugar;

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

        Food food1 = new Food("Noodle wagon", 24.00, 1100, 110, 20, 10);
        Food food2 = new Food("Scrambled eggs", 8.00, 420, 30, 40, 10);
        Food food3 = new Food("Rice & chicken", 26.00, 1300, 150, 50, 10);
        Food food4 = new Food("Vegetable salad", 15.00, 360, 20, 10, 30);
        Food food5 = new Food("Chocolate cake", 42.00, 670, 10, 80, 90);

        offerFoodList = new ArrayList<>();
        offerFoodList.add(food1);
        offerFoodList.add(food2);
        offerFoodList.add(food3);
        offerFoodList.add(food4);
        offerFoodList.add(food5);

        offerFoodAdapter = new OfferFoodAdapter(offerFoodList, this);
        rvOfferFood.setAdapter(offerFoodAdapter);

        /* ************************************************************************************** */

        Intent intent = getIntent();
        givenProteins = Integer.parseInt(intent.getStringExtra("proteins"));
        givenFats = Integer.parseInt(intent.getStringExtra("fats"));
        givenSugar = Integer.parseInt(intent.getStringExtra("sugar"));

        tvChosenProteins = (TextView) findViewById(R.id.tv_choosen_proteins);
        tvChosenFats = (TextView) findViewById(R.id.tv_chosen_fats);
        tvChosenSugar = (TextView) findViewById(R.id.tv_chosen_sugar);

        tvGivenProteins = (TextView) findViewById(R.id.tv_given_proteins);
        tvGivenProteins.setText(givenProteins + " g");
        tvGivenFats = (TextView) findViewById(R.id.tv_given_fats);
        tvGivenFats.setText(givenFats + " g");
        tvGivenSugar = (TextView) findViewById(R.id.tv_given_sugar);
        tvGivenSugar.setText(givenSugar + " g");

    }

    @Override
    public void onItemClick(int position) {
        Food clickedFood = offerFoodList.get(position);

        if (clickedFood.isMarkFlag() == true) {
            clickedFood.setMarkFlag(false);
            proteinsSum -= clickedFood.getProteins();
            fatsSum -= clickedFood.getFats();
            sugarSum -= clickedFood.getSugar();
        } else {
            clickedFood.setMarkFlag(true);
            proteinsSum += clickedFood.getProteins();
            fatsSum += clickedFood.getFats();
            sugarSum += clickedFood.getSugar();
        }

        String state = clickedFood.isMarkFlag() ? "Marked!" : "Unmarked!";
        Toast.makeText(this, clickedFood.getName() + ": " + state, Toast.LENGTH_SHORT).show();

        tvChosenProteins.setText(proteinsSum + " g");
        tvChosenFats.setText(fatsSum + " g");
        tvChosenSugar.setText(sugarSum + " g");
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
