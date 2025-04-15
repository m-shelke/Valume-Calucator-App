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

public class CubeActivity extends AppCompatActivity {

    //init XML Views
    TextView resultTv;
    EditText sideEd;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //finding XML Views
        resultTv = findViewById(R.id.resultTv);
        sideEd = findViewById(R.id.sideEd);
        calculate = findViewById(R.id.calculateBtn);

        //Handle click event on button
        calculate.setOnClickListener(v -> {
            //Getting value for EditText widget
            String side = sideEd.getText().toString();

            //parse String-->Int
            int intSide = Integer.parseInt(side);

            // Sphere Formul V = side*side*side so,
            int volume = intSide*intSide*intSide;

            //setting volume result to resultTv TextView
            resultTv.setText("V: "+volume +" cubic unit"); //m^3 means cube 3

        });
    }
}