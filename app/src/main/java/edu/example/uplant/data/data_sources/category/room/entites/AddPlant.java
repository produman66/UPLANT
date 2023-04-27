package edu.example.uplant.data.data_sources.category.room.entites;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.models.AddPlant1;
import edu.example.uplant.data.data_sources.category.models.Item;

@Entity(tableName = "plant_add")
public class AddPlant {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "plant")
    public String name;

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @ColumnInfo(name="descr")
    public String desc;

    @NonNull
    @ColumnInfo(name = "poliv")
    public String poliv;

    @NonNull
    @ColumnInfo(name = "peresad")
    public String peresad;

    @NonNull
    @ColumnInfo(name = "udobr")
    public String udobr;


    @ColumnInfo(name = "nameimage")
    public String nameimage;

    @ColumnInfo(name = "zametky")
    public String zametky;

    public String getZametky() {
        return zametky;
    }

    @Ignore
    ImageView image;

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getDesc() {
        return desc;
    }

    @NonNull
    public String getPoliv() {
        return poliv;
    }

    @NonNull
    public String getPeresad() {
        return peresad;
    }

    @NonNull
    public String getUdobr() {
        return udobr;
    }

    public String getNameimage() {
        return nameimage;
    }

    public ImageView getImage() {
        return image;
    }

    public AddPlant1 toDomainMode() {
        return new AddPlant1(name, desc, poliv, peresad, udobr, nameimage, zametky);
    }

    public AddPlant(@NonNull String name, @NonNull String desc, @NonNull String poliv, @NonNull String peresad, @NonNull String udobr, String nameimage, String zametky) {
        this.name=name;
        this.desc=desc;
        this.poliv=poliv;
        this.peresad=peresad;
        this.udobr=udobr;
        this.nameimage=nameimage;
        this.zametky=zametky;

    }

}
