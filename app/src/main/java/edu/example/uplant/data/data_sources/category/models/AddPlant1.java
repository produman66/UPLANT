package edu.example.uplant.data.data_sources.category.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;

public class AddPlant1 {
    private String name;
    private String desc;
    private String poliv;
    private String peresad;
    private String udobr;

    public String getDesc() {return desc;
    }

    public String getPoliv() {return poliv;
    }

    public String getPeresad() {return peresad;
    }

    public String getUdobr() {return udobr;
    }

    public String getNameimage() {
        return nameimage;
    }

    private String nameimage;
    private String zametky;

    public String getZametky() {return zametky;}


    public String getName() {return name;}

    public AddPlant1(String name, String desc, String poliv, String peresad, String udobr, String nameimage, String zametky) {
        this.name=name;
        this.desc=desc;
        this.poliv=poliv;
        this.peresad=peresad;
        this.udobr=udobr;
        this.nameimage=nameimage;
        this.zametky=zametky;

    }
}
