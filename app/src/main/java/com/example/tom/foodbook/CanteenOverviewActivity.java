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
import com.example.tom.foodbook.Entity.Canteen;

import java.util.ArrayList;

public class CanteenOverviewActivity extends AppCompatActivity {

    private Canteen canteen;
    private CsvHelper csvHelper;


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

    }

}
