package edu.example.uplant.data.data_sources.category.room.entites;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.room.entites.Plant;

@Entity(
        foreignKeys = @ForeignKey(entity = Plant.class,
                parentColumns = "id",
                childColumns = "idcategori",
                onDelete = ForeignKey.CASCADE),
        primaryKeys = {"idcategori", "plantid"})
public class MyPlant {
    public int plantid;
    public int getIdcateg() {
        return idcateg;
    }
    @NonNull
    public String getmWord1() {
        return plantname;
    }
    @NonNull
    public String getDescr() {
        return descr;
    }
    @NonNull
    public String getPoliv() {
        return poliv;
    }
    @NonNull
    public String getPeresadka() {
        return peresadka;
    }
    @NonNull
    public String getUdobr() {return udobr;
    }
    @NonNull
    public String getDescrplant() {
        return descrplant;
    }
    @NonNull
    public String getPolivplant() {
        return polivplant;
    }
    @NonNull
    public String getPeresadkaplant() {
        return peresadkaplant;
    }
    @NonNull
    public String getUdobrplant() {
        return udobrplant;
    }
    @NonNull
    public String getNameimage() {
        return nameimage;
    }
    public ImageView getImage1() {
        return image1;
    }
    @NonNull
    @ColumnInfo(name = "idcategori")
    public int idcateg;
    @NonNull
    @ColumnInfo(name = "plantname")
    public String plantname;
    @NonNull
    @ColumnInfo(name = "descr")
    public String descr;
    @NonNull
    @ColumnInfo(name = "poliv")
    public String poliv;
    @NonNull
    @ColumnInfo(name = "peresadka")
    public String peresadka;
    @NonNull
    @ColumnInfo(name = "udobr")
    public String udobr;
    @NonNull
    @ColumnInfo(name = "descrplant")
    public String descrplant;
    @NonNull
    @ColumnInfo(name = "polivplant")
    public String polivplant;
    @NonNull
    @ColumnInfo(name = "peresadkaplant")
    public String peresadkaplant;
    @NonNull
    @ColumnInfo(name = "udobrplant")
    public String udobrplant;
    public MyPlant() {}
    @NonNull
    @ColumnInfo(name = "nameimage1")
    public String nameimage;

    public boolean isFavorite() {
        return favorite;
    }
    public boolean isAddplant() {
        return addplant;
    }
    @NonNull
    @ColumnInfo(name = "favorite")
    public boolean favorite;
    @NonNull
    @ColumnInfo(name = "addplant")
    public boolean addplant;
    @Ignore
    ImageView image1;

    public MyPlant(int plantid, int idcateg, @NonNull String mWord1, @NonNull String descr, @NonNull String poliv, @NonNull String peresadka, @NonNull String udobr, @NonNull String descrplant, @NonNull String polivplant, @NonNull String peresadkaplant, @NonNull String udobrplant, @NonNull String nameimage, boolean favorite, boolean addplant) {
        this.plantid=plantid;
        this.idcateg = idcateg;
        this.plantname = mWord1;
        this.descr = descr;
        this.poliv = poliv;
        this.peresadka = peresadka;
        this.udobr = udobr;
        this.descrplant = descrplant;
        this.polivplant = polivplant;
        this.peresadkaplant = peresadkaplant;
        this.udobrplant = udobrplant;
        this.nameimage = nameimage;
        this.favorite = favorite;
        this.addplant = addplant;
    }
}
