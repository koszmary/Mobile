package com.sdmobile.addingapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Variables
    EditText number1,number2;
    Button Add_button;
    TextView temp,result;
    int ans=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assiging the values to variables
        number1=(EditText) findViewById(R.id.first_number);
        number2=(EditText) findViewById(R.id.second_number);
        Add_button=(Button) findViewById(R.id.button);
        result=(TextView) findViewById(R.id.result_value);
        temp=(TextView) findViewById(R.id.result);

        Add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());
                // add both number and store it to sum
                double sum = num1 + num2;
                // set it ot result textviewe
                result.setText(Double.toString(sum));

                temp.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);
            }
        });
    }
}