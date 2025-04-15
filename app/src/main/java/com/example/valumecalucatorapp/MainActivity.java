package com.example.valumecalucatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1-init AdapterView
    GridView gridView;

    //instance of the both Adapter class that's DiagramAdapter and Model Class i.e DiagramModel

    //2-Data Source: DiagramModel
    ArrayList<DiagramModel> arrayList;
    //3-Adapter: DiagramAdapter
    DiagramAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //finding XML Views
        gridView = findViewById(R.id.gridView);

        //init Model class
        arrayList = new ArrayList<>();

        //calling DiagramModel class and passing req. constructor parameter that is Diagram Image and Diagram Name
        DiagramModel model1 = new DiagramModel(R.drawable.sphere, "Sphere");
        DiagramModel model2 = new DiagramModel(R.drawable.cylinder, "Cylinder");
        DiagramModel model3 = new DiagramModel(R.drawable.cube, "Cube");
        DiagramModel model4 = new DiagramModel(R.drawable.prism, "Prism");

        //adding data to arraylist
        arrayList.add(model1);
        arrayList.add(model2);
        arrayList.add(model3);
        arrayList.add(model4);

        //calling Adapter Class and passing Data Source and Context of Application
        adapter = new DiagramAdapter(arrayList, getApplicationContext());

        //set adapter to GridLayout
        gridView.setAdapter(adapter);

        //setting no. of column in GridView
        gridView.setNumColumns(2);

        //handling clicked event on gridView item clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showing Toast message
                Toast.makeText(MainActivity.this, "Diagram click: " + adapter.getItem(position).getDiagramName(), Toast.LENGTH_SHORT).show();

                if (adapter.getItem(position).getDiagramName() == model1.getDiagramName()) {

                    //start new Activity on GridView's items clicked, using Intent class
                    Intent intent = new Intent(MainActivity.this, SphereActivity.class);
                    //starting Activity
                    startActivity(intent);
                }

                //handling clicked event on gridView item clicked
                if (adapter.getItem(position).getDiagramName() == "Cylinder") {

                    //start new Activity on GridView's items clicked, using Intent class
                    Intent intent = new Intent(MainActivity.this, CylinderActivity.class);
                    //starting Activity
                    startActivity(intent);
                }

                //handling clicked event on gridView item clicked
                if (adapter.getItem(position).getDiagramName() == "Cube") {

                    //start new Activity on GridView's items clicked, using Intent class
                    Intent intent = new Intent(MainActivity.this, CubeActivity.class);
                    //starting Activity
                    startActivity(intent);
                }

                //handling clicked event on gridView item clicked
                if (adapter.getItem(position).getDiagramName() == model4.diagramName) {

                    //start new Activity on GridView's items clicked, using Intent class
                    Intent intent = new Intent(MainActivity.this, PrismActivity.class);
                    //starting Activity
                    startActivity(intent);
                }
            }
        });
    }
}