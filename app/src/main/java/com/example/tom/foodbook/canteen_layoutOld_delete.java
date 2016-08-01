package com.example.tom.foodbook;

import android.graphics.Typeface;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class canteen_layoutOld_delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_overview);

        TextView textView = (TextView) findViewById(R.id.canteenNo);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/blokletters_balpen.ttf");
        textView.setTypeface(tf, Typeface.NORMAL);

    }

}
