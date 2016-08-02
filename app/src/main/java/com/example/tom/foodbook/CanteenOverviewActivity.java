package com.example.tom.foodbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tom.foodbook.Adapter.OfferCanteenAdapter;
import com.example.tom.foodbook.Adapter.OfferFoodAdapter;
import com.example.tom.foodbook.Adapter.OfferFoodCompactAdapter;
import com.example.tom.foodbook.Entity.Canteen;
import com.example.tom.foodbook.Entity.Food;

import java.util.ArrayList;

public class CanteenOverviewActivity extends AppCompatActivity implements OfferFoodCompactAdapter.ViewHolder.ClickListener {

    private Canteen canteen;
    private CsvHelper csvHelper;

    public static final String MIBA_TAG = "MIBA_TAG";

    private ArrayList<Food> offerFoodList;
    private RecyclerView rvOfferFood;
    private RecyclerView.LayoutManager offerFoodLayoutManager;
    private OfferFoodCompactAdapter offerFoodAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_overview);

        Intent intent = getIntent();

        this.csvHelper = new CsvHelper(CanteenOverviewActivity.this);
        this.canteen = csvHelper.getCanteenByID(intent.getIntExtra("canteenId", 666));

        TextView canteenNo = (TextView) findViewById(R.id.canteenNo);
        TextView descriptionOfCanteen = (TextView) findViewById(R.id.descriptionOfCanteen);
        TextView tv_building_name = (TextView) findViewById(R.id.tv_building_name);

        ImageView img_canteen = (ImageView) findViewById(R.id.img_canteen);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/blokletters_balpen.ttf");
        canteenNo.setTypeface(tf, Typeface.NORMAL);
        canteenNo.setText("Canteen name: " + canteen.getName());

        descriptionOfCanteen.setText(canteen.getDescription());

        tv_building_name.setText("Building: " + canteen.getBuilding());

        img_canteen.setImageResource(canteen.getImageResource(CanteenOverviewActivity.this));



                /* ************************************************************************************** */

        //RecyclerView.ItemDecoration itemDecoration
        rvOfferFood = (RecyclerView) findViewById(R.id.rv_offer_canteen);
        rvOfferFood.setHasFixedSize(true);
        offerFoodLayoutManager = new LinearLayoutManager(this);
        rvOfferFood.setLayoutManager(offerFoodLayoutManager);

        /* ************************************************************************************** */

        CsvHelper csvHelper = new CsvHelper(CanteenOverviewActivity.this);
        this.offerFoodList = csvHelper.getFoodsOfCanteen(canteen.getId());

        offerFoodAdapter = new OfferFoodCompactAdapter(offerFoodList, CanteenOverviewActivity.this, this);
        rvOfferFood.setAdapter(offerFoodAdapter);



    }

    @Override
    public void onItemClick(int position) {

    }
}
