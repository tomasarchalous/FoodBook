package com.example.tom.foodbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tom.foodbook.Adapter.OfferCanteenAdapter;
import com.example.tom.foodbook.Entity.Canteen;

import java.util.ArrayList;

public class CanteenOverviewActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_overview);

        TextView textView = (TextView) findViewById(R.id.canteenNo);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/blokletters_balpen.ttf");
        textView.setTypeface(tf, Typeface.NORMAL);


    }

}
