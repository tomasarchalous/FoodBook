package com.example.tom.foodbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Mira on 1.8.2016.
 */
public class NutritionFormActivity extends AppCompatActivity {

    public static final String MIBA_TAG = "MIBA_TAG";

    private EditText etGivenProteins, etGivenFats, etGivenSugar;
    private Button btnStorno, btnOK;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition_form);

        etGivenProteins = (EditText) findViewById(R.id.et_given_proteins);
        etGivenFats = (EditText) findViewById(R.id.et_given_fats);
        etGivenSugar = (EditText) findViewById(R.id.et_given_sugar);

        btnStorno = (Button) findViewById(R.id.btn_storno);
        btnStorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CleverFilterActivity.class);

                String givenProteins = etGivenProteins.getText().toString().trim();
                String givenFats = etGivenFats.getText().toString().trim();
                String givenSugar = etGivenSugar.getText().toString().trim();

                intent.putExtra("proteins", givenProteins.equals("") ? "0" : givenProteins);
                intent.putExtra("fats", givenFats.equals("") ? "0" : givenFats);
                intent.putExtra("sugar", givenSugar.equals("") ? "0" : givenSugar);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MIBA_TAG, "NutritionFormActivity START");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MIBA_TAG, "NutritionFormActivity STOP");
    }
}
