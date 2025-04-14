package com.example.valumecalucatorapp;

public class DiagramModel {

/*    This class is acting as: "Model Class" it represent the data
     structure or individual data items that your Adapter is going to Display*/

    //Attributes
    int diagramImg;
    String diagramName;

    //Constructor
    public DiagramModel(int diagramImg, String diagramName) {
        this.diagramImg = diagramImg;
        this.diagramName = diagramName;
    }

    //Getters and Setters

    public int getDiagramImg() {
        return diagramImg;
    }

    public void setDiagramImg(int diagramImg) {
        this.diagramImg = diagramImg;
    }

    public String getDiagramName() {
        return diagramName;
    }

    public void setDiagramName(String diagramName) {
        this.diagramName = diagramName;
    }
}
