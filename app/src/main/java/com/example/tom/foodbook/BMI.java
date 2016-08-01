package com.example.tom.foodbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }
    /**
     * This method is called when pressing calculate button
     */
    public void calculate(View view){
        //get input height and weight
        EditText heightField = (EditText)findViewById( R.id.height);
        double height = Integer.parseInt(heightField.getText().toString());
        EditText weightField = (EditText)findViewById(R.id.weight);
        double weight = Integer.parseInt(weightField.getText().toString());
        double BMI = BMICalculation(height, weight);
        //get the exercise intensity
        RadioButton mode1 = (RadioButton) findViewById(R.id.mode1);
        boolean layDown = mode1.isChecked();
        RadioButton mode2 = (RadioButton) findViewById(R.id.mode2);
        boolean slightExe = mode2.isChecked();
        RadioButton mode3 = (RadioButton) findViewById(R.id.mode3);
        boolean normalExe = mode3.isChecked();
        RadioButton mode4 = (RadioButton) findViewById(R.id.mode4);
        boolean heavyExe = mode4.isChecked();
        /**
         * Underweight =<18.5
         * Normal weight = 18.5 - 24.9
         * Overweight = 25 - 29.9
         * Obesity = BMI of 30 or greater
         */
        String summary = createSummary(BMI);
        displaySummary(summary);
        String recommendation = createRecommendation(weight, layDown, slightExe, normalExe, heavyExe);
        displayRecommendation(recommendation);
    }
    /**
     * Run BMI formula
     * BMI = weight/(height*height)
     * weight(kg)
     * height(m)
     */
    private double BMICalculation(double height, double weight){
        double BMI = weight / ((height/100) * (height/100));
        BigDecimal b = new BigDecimal(BMI);
        double BMIresult = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return BMIresult;
    }
    /**
     * This method creates summary
     */
    public String createSummary(double BMI){
        String summary = "Your BMI value is: " + BMI;
        if (BMI <= 18.5)    summary += "\nYou are underweight!";
        else if (BMI < 25 && BMI > 18.5 ) summary += "\nCongratulations! You have normal weight!";
        else if (BMI >=25 && BMI <30)   summary += "\nYou are overweight!";
        else if (BMI >= 30) summary += "\nYou are obesity!";
        else    summary += "\nAre you sure about your input weight and heght?";
        return summary;
    }
    /**
     * This method displays recommend intake calories based on weight and exercise intensity
     * Basal Metabolic Rate: BMR(kJ) = weight(kg) * 24 (hr)
     * Resting Energy Expenditure: REE = BMR * 1.1
     * daily required calories = REE * k
     * 1. lay down all day: k = 1.2
     * 2. slight exercise: k = 1.3
     * 3. normal exercise: k = 1.5 - 1.75
     * 4. heavy exercise: k = 2.0
     */
    public String createRecommendation(double weight, boolean layDown, boolean slightExe,
                                       boolean normalExe, boolean heavyExe){
        String recommendation = "Based on your weight: " + weight + "kg";
        double k = 1.0;
        if(layDown) k = 1.2;
        if(slightExe)   k = 1.3;
        if (normalExe)  k = 1.6;
        if (heavyExe)   k = 2.0;
        double requiredCalories = weight * 24 * 1.1 * k;
        BigDecimal b = new BigDecimal(requiredCalories);
        double requiredCalRes = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        recommendation += "\nThe ideal amount of daily intake calories is: " + requiredCalRes + "KJ";
        return recommendation;
    }
    /**
     * This method displays the summary on the screen
     */
    private void displaySummary (String summary){
        TextView summaryTextView = (TextView)findViewById(R.id.summary);
        summaryTextView.setText(summary);
    }
    /**
     * This method displays the recommendation on the screen
     */
    private void displayRecommendation (String recommendation){
        TextView recommendationTextView = (TextView)findViewById(R.id.recommendation);
        recommendationTextView.setText(recommendation);
    }


}
