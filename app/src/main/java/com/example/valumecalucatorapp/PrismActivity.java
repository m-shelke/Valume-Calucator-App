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

public class PrismActivity extends AppCompatActivity {

    //init XML Views
    TextView resultTv;
    EditText baseAreaEd,hieghtEd;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //finding XML Views
        resultTv = findViewById(R.id.resultTv);
        baseAreaEd = findViewById(R.id.baseAreaEd);
        calculate = findViewById(R.id.calculateBtn);
        hieghtEd = findViewById(R.id.heightEd);

        //Handle click event on button
        calculate.setOnClickListener(v -> {
            //Getting value for EditText widget
            String baseArea = baseAreaEd.getText().toString();
            //Getting Height from EditText
            String height = hieghtEd.getText().toString();

            //parse String-->Int
            int intBaseArea = Integer.parseInt(baseArea);
            int intHeight = Integer.parseInt(height);

            // Sphere Formula V = PI*r^2*h so, we used Math.PI class and method to get PI Value
            int volume = intBaseArea*intHeight;

            //setting volume result to resultTv TextView
            resultTv.setText("V: "+volume +" cm^3"); //cm^3 means cubic meter cube 3

        });
    }
}