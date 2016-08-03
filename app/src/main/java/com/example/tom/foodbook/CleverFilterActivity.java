package com.example.tom.foodbook;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tom.foodbook.Adapter.OfferFoodAdapter;
import com.example.tom.foodbook.Entity.Food;
import com.example.tom.foodbook.Entity.NutritionValue;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Mira on 29.7.2016.
 */
public class CleverFilterActivity extends AppCompatActivity implements OfferFoodAdapter.ViewHolder.ClickListener {

    public static final String MIBA_TAG = "MIBA_TAG";

    private ArrayList<Food> offerFoodList;
    private ArrayList<NutritionValue> nutritionValueList;
    private SwipeRefreshLayout srlOfferFoodList;
    private RecyclerView rvOfferFood;
    private RecyclerView.LayoutManager offerFoodLayoutManager;
    private OfferFoodAdapter offerFoodAdapter;
    private TextView tvChosenProteins, tvChosenFats, tvChosenSugar, tvGivenProteins, tvGivenFats, tvGivenSugar;
    private PieChart pcNutritionValues;
    private Typeface tf;

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

        srlOfferFoodList = (SwipeRefreshLayout) findViewById(R.id.srl_offer_food_list);
        srlOfferFoodList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(MIBA_TAG, "▲ REFRESH");
                setpcNutritionValuesData(nutritionValueList);
                srlOfferFoodList.setRefreshing(false);
            }
        });

        tvChosenProteins = (TextView) findViewById(R.id.tv_choosen_proteins);
        tvChosenFats = (TextView) findViewById(R.id.tv_chosen_fats);
        tvChosenSugar = (TextView) findViewById(R.id.tv_chosen_sugar);

        Intent intent = getIntent();
        givenProteins = Integer.parseInt(intent.getStringExtra("proteins"));
        givenFats = Integer.parseInt(intent.getStringExtra("fats"));
        givenSugar = Integer.parseInt(intent.getStringExtra("sugar"));

        tvGivenProteins = (TextView) findViewById(R.id.tv_given_proteins);
        tvGivenProteins.setText(givenProteins + " g");
        tvGivenFats = (TextView) findViewById(R.id.tv_given_fats);
        tvGivenFats.setText(givenFats + " g");
        tvGivenSugar = (TextView) findViewById(R.id.tv_given_sugar);
        tvGivenSugar.setText(givenSugar + " g");

        NutritionValue nutritionValue1 = new NutritionValue("Proteins", givenProteins);
        NutritionValue nutritionValue2 = new NutritionValue("Fats", givenFats);
        NutritionValue nutritionValue3 = new NutritionValue("Sugar", givenSugar);

        nutritionValueList = new ArrayList<>();
        nutritionValueList.add(nutritionValue1);
        nutritionValueList.add(nutritionValue2);
        nutritionValueList.add(nutritionValue3);
        Log.d(MIBA_TAG, "▲ List size: " + nutritionValueList.size());

        pcNutritionValues = (PieChart) findViewById(R.id.pc_nutrition_values);
        tf = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");
        setpcNutritionValuesData(nutritionValueList);
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

    public void setpcNutritionValuesData(ArrayList<NutritionValue> nutritionValuesList) {
        int countOfNonNullableRecords = 0;
        int entryNumber = 0;
        ArrayList<String> xVals = new ArrayList<>();
        ArrayList<Entry> yVals = new ArrayList<>();             // Entry reprezentuje 1 vstup grafu


        for (NutritionValue n : nutritionValuesList) {
            countOfNonNullableRecords++;
            xVals.add(entryNumber, n.getName().toString());
            yVals.add(new Entry((float) n.getValue(), entryNumber));
            entryNumber++;
        }

        if (countOfNonNullableRecords > 0) {
            pcNutritionValues.setVisibility(View.VISIBLE);

            PieDataSet dataSet = new PieDataSet(yVals, "");
            dataSet.setSliceSpace(5f);
            dataSet.setSelectionShift(10f);

            ArrayList<Integer> colors = new ArrayList<>();

            for (int c : ColorTemplate.VORDIPLOM_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.JOYFUL_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.COLORFUL_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.LIBERTY_COLORS)
                colors.add(c);

            for (int c : ColorTemplate.PASTEL_COLORS)
                colors.add(c);

            colors.add(ColorTemplate.getHoloBlue());
            dataSet.setColors(colors);

            PieData data = new PieData(xVals, dataSet);
            data.setValueFormatter(new DefaultValueFormatter(10));
            data.setValueTypeface(tf);
            data.setValueTextSize(10f);
            data.setValueTextColor(Color.BLACK);

            setpcNutritionValues();
            pcNutritionValues.setData(data);
            pcNutritionValues.setNoDataText("NO DATA");
            pcNutritionValues.invalidate();
        }
    }

    public void setpcNutritionValues() {
        pcNutritionValues.setDescription("gramme");
        pcNutritionValues.setHoleRadius(58f);
        pcNutritionValues.setTransparentCircleRadius(61f);
        pcNutritionValues.setCenterTextTypeface(tf);
        pcNutritionValues.setCenterTextTypeface(tf);
        pcNutritionValues.setCenterTextSize(13f);

        pcNutritionValues.setUsePercentValues(false);
        pcNutritionValues.setHighlightPerTapEnabled(true);
        pcNutritionValues.setExtraOffsets(5, 10, 5, 5);
        pcNutritionValues.setDragDecelerationFrictionCoef(0.95f);

        pcNutritionValues.setDrawHoleEnabled(true);
        pcNutritionValues.setTransparentCircleColor(Color.WHITE);
        pcNutritionValues.setTransparentCircleAlpha(110);
        pcNutritionValues.setHoleColor(Color.WHITE);

        pcNutritionValues.setDrawCenterText(true);
        pcNutritionValues.setCenterText("Nutrition\nvalues");

        pcNutritionValues.setRotationEnabled(false);
        pcNutritionValues.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        Legend legend = pcNutritionValues.getLegend();
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        legend.setYEntrySpace(0f);
        legend.setYOffset(0f);

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
