package edu.example.uplant.data.data_sources.category.room.entites;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;

@Entity(tableName = "plant_add", foreignKeys = @ForeignKey(entity = Users.class,
        parentColumns = "email",
        childColumns = "iduser",
        onDelete = ForeignKey.CASCADE))
public class AddPlant {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String getIduser() {
        return iduser;
    }

    public void setIduser(@NonNull String iduser) {
        this.iduser = iduser;
    }

    @NonNull
    @ColumnInfo(name = "iduser")
    public String iduser;


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

    public AddPlantModel toDomainModel() {
        return new AddPlantModel(id, iduser, name, desc, poliv, peresad, udobr, nameimage, zametky);
    }

    public AddPlant(@NonNull String iduser, @NonNull String name, @NonNull String desc, @NonNull String poliv, @NonNull String peresad, @NonNull String udobr, String nameimage, String zametky) {
        this.id = id;
        this.iduser = iduser;
        this.name=name;
        this.desc=desc;
        this.poliv=poliv;
        this.peresad=peresad;
        this.udobr=udobr;
        this.nameimage=nameimage;
        this.zametky=zametky;

    }

}
