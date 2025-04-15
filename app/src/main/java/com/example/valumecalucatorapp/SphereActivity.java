package com.example.valumecalucatorapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SphereActivity extends AppCompatActivity {

    //init XML Views
    TextView resultTv;
    EditText radiusEd;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //finding XML Views
        resultTv = findViewById(R.id.resultTv);
        radiusEd = findViewById(R.id.radiusEd);
        calculate = findViewById(R.id.calculateBtn);

        //Handle click event on button
        calculate.setOnClickListener(v -> {
            //Getting value for EditText widget
            String radius = radiusEd.getText().toString();

            //parse String-->Int
            int intRadius = Integer.parseInt(radius);

           // Sphere Formula  V = (4/3)*Pi * r^3 so, we used Math.PI class and method to get PI Value
            int volume = (int) (((double) 4 /3) * Math.PI *intRadius*intRadius*intRadius);

            //setting volume result to resultTv TextView
            resultTv.setText("V: "+volume +" m^3"); //m^3 means cube 3

        });


    }
}