package com.example.valumecalucatorapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiagramAdapter extends ArrayAdapter<DiagramModel> {

    //Attributes
    private ArrayList<DiagramModel> arrayList;
    Context context;

    //Constructor
    public DiagramAdapter(ArrayList<DiagramModel> arrayList, Context context) {
        super(context, R.layout.grid_item_layout,arrayList);
        this.arrayList = arrayList;
        this.context = context;
    }

    //ViewHolder Class: Used to cache references to the views within grid_items_layout
    public static class MyViewHolder{
        TextView diagramName;
        ImageView diagramImg;
    }


    //getView(): Method used to created and return a views for a specific item in Grid Layout
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //1- Get the DiagramModel obj for the current position
        DiagramModel diagramModel = getItem(position);

        //2-Inflating Layout:
        MyViewHolder myViewHolder;

        if (convertView == null){
            //No views went off-screen --> Create a new view
            myViewHolder = new MyViewHolder();
            //inflating layout's views
           LayoutInflater inflater = LayoutInflater.from(context);

           //getting grid_items_layout in convertView
            convertView = inflater.inflate(R.layout.grid_item_layout,parent,false);

            //Finding the views
            myViewHolder.diagramName = convertView.findViewById(R.id.itemTv);
            myViewHolder.diagramImg = convertView.findViewById(R.id.itemIv);

            //Attaching via setTag method
            convertView.setTag(myViewHolder);

        }else {
            //a view went off-screen --> re-used it , (getTag(): used to get previously attached view and recycled it)
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        //Getting the data from the model class that's DiagramModel
        myViewHolder.diagramName.setText(diagramModel.getDiagramName());
        myViewHolder.diagramImg.setImageResource(diagramModel.getDiagramImg());

        //returning convertView
        return convertView;
    }
}

