package com.example.tom.foodbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        EditText heightField = (EditText)findViewById( R.id.height);
        double height = Integer.parseInt(heightField.getText().toString());
        EditText weightField = (EditText)findViewById(R.id.weight);
        double weight = Integer.parseInt(weightField.getText().toString());
        double BMI = BMICalculation(height, weight);
        /**
         * Underweight =<18.5
         * Normal weight = 18.5 - 24.9
         * Overweight = 25 - 29.9
         * Obesity = BMI of 30 or greater
         */
        String summary = createSummary(BMI);
        display(summary);
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
     * This method displays the summary on the screen
     */
    private void display (String summary){
        TextView summaryTextView = (TextView)findViewById(R.id.summary);
        summaryTextView.setText(summary);
    }

}
