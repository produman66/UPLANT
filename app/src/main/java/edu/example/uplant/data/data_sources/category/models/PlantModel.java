package edu.example.uplant.data.data_sources.category.models;

public class PlantModel {
    private int id;
    private String name;
    private String nameimage;

    public int getId() {return id;}

    public String getName() {return name;}

    public String getNameimage() {return nameimage;}

    public PlantModel(int id, String name, String nameimage) {
        this.id = id;
        this.name = name;
        this.nameimage = nameimage;
    }


}
