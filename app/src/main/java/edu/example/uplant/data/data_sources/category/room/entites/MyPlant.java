package edu.example.uplant.data.data_sources.category.room.entites;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;

import edu.example.uplant.data.data_sources.category.models.MyPlantModel;

@Entity(
        foreignKeys = @ForeignKey(entity = Plant.class,
                parentColumns = "id",
                childColumns = "idcateg",
                onDelete = ForeignKey.CASCADE),
        primaryKeys = {"idcateg", "plantid"})
public class MyPlant {

    public int plantid;

    @NonNull
    @ColumnInfo(name = "idemail")
    public String idemail;


    @NonNull
    @ColumnInfo(name = "idcateg")
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
    @ColumnInfo(name = "razmnozh")
    public String razmnozh;

    @NonNull
    @ColumnInfo(name = "zash")
    public String zash;

    @NonNull
    @ColumnInfo(name = "tempa")
    public String tempa;

    @NonNull
    @ColumnInfo(name = "vlaga")
    public String vlaga;

    @NonNull
    @ColumnInfo(name = "svet")
    public String svet;

    @NonNull
    @ColumnInfo(name = "obrez")
    public String obrez;


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

    @NonNull
    @ColumnInfo(name = "nameimage1")
    public String nameimage;

    @NonNull
    @ColumnInfo(name = "favorite")
    public boolean favorite;

    @Ignore
    ImageView image1;


    public int getIdcateg() {
        return idcateg;
    }
    @NonNull
    public String getName() {
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
    public String getUdobr() {return udobr;}
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
    public boolean isFavorite() {
        return favorite;
    }
    @NonNull
    public String getIdemail() {return idemail;}

    @NonNull
    public String getRazmnozh() {return razmnozh;}

    @NonNull
    public String getZash() {return zash;}

    @NonNull
    public String getTempa() {return tempa;}

    @NonNull
    public String getVlaga() {return vlaga;}

    @NonNull
    public String getSvet() {return svet;}

    @NonNull
    public String getObrez() {return obrez;}

    public void setIdemail(@NonNull String idemail) {this.idemail = idemail;}


    public MyPlant() {}
    public MyPlant(String idemail, int plantid, int idcateg, @NonNull String name, @NonNull String descr, @NonNull String poliv, @NonNull String peresadka, @NonNull String udobr, @NonNull String razmnozh, @NonNull String obrez, @NonNull String zash, @NonNull String svet, @NonNull String tempa, @NonNull String vlaga,   @NonNull String descrplant, @NonNull String polivplant, @NonNull String peresadkaplant, @NonNull String udobrplant, @NonNull String nameimage, boolean favorite) {
        this.idemail=idemail;
        this.plantid=plantid;
        this.idcateg = idcateg;
        this.plantname = name;
        this.descr = descr;
        this.poliv = poliv;
        this.peresadka = peresadka;
        this.udobr = udobr;
        this.razmnozh = razmnozh;
        this.obrez = obrez;
        this.zash = zash;
        this.svet = svet;
        this.tempa = tempa;
        this.vlaga = vlaga;
        this.descrplant = descrplant;
        this.polivplant = polivplant;
        this.peresadkaplant = peresadkaplant;
        this.udobrplant = udobrplant;
        this.nameimage = nameimage;
        this.favorite = favorite;
    }

    public MyPlantModel toDomainModel() {
        return new MyPlantModel(plantid, idcateg, plantname, descr, poliv, peresadka, udobr, razmnozh, obrez, zash, svet, tempa, vlaga, descrplant, polivplant, peresadkaplant, udobrplant, nameimage, favorite);
    }
}
