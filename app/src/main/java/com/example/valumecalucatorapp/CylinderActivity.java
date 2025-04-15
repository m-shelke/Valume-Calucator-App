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

public class CylinderActivity extends AppCompatActivity {

    //init XML Views
    TextView resultTv;
    EditText radiusEd,hieghtEd;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //finding XML Views
        resultTv = findViewById(R.id.resultTv);
        radiusEd = findViewById(R.id.radiusEd);
        calculate = findViewById(R.id.calculateBtn);
        hieghtEd = findViewById(R.id.heightEd);

        //Handle click event on button
        calculate.setOnClickListener(v -> {
            //Getting value for EditText widget
            String radius = radiusEd.getText().toString();
            //Getting Height from EditText
            String height = hieghtEd.getText().toString();

            //parse String-->Int
            int intRadius = Integer.parseInt(radius);
            int intHeight = Integer.parseInt(height);

            // Sphere Formula V = PI*r^2*h so, we used Math.PI class and method to get PI Value
            int volume = (int) (Math.PI*intRadius*intRadius*intHeight);

            //setting volume result to resultTv TextView
            resultTv.setText("V: "+volume +" cm"); //m^3 means cube 3

        });
    }
}