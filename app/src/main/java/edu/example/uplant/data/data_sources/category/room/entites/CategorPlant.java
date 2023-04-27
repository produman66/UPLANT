package edu.example.uplant.data.data_sources.category.room.entites;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

import java.util.List;

public class CategorPlant {
    @Ignore
    public MyPlant myPlant;
    @Embedded
    public Plant plant;
    @Relation(parentColumn = "id", entity = MyPlant.class, entityColumn = "idcategori")
    public List<MyPlant> myPlants;
}
