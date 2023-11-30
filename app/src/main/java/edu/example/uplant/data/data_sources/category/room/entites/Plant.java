package edu.example.uplant.data.data_sources.category.room.entites;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.models.PlantModel;

@Entity(tableName = "plant_categ_table")
public class Plant {

    @PrimaryKey
    public int id;

    @NonNull
    @ColumnInfo(name = "plant")
    public String name;

    @NonNull
    @ColumnInfo(name = "nameimage")
    public String nameimage;

    @Ignore
    ImageView image;


    public String getName(){return this.name;}
    public String getImage1() {return this.nameimage;}
    public int getId() {
        return id;
    }


    public Plant() {}
    public Plant( int id, @NonNull String name, @NonNull String nameimage) {
        this.id = id;
        this.name = name;
        this.nameimage = nameimage;
    }
    public PlantModel toDomainModel() {
        return new PlantModel(id, name, nameimage);
    }
}
