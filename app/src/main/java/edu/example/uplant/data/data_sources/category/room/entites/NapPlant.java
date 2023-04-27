package edu.example.uplant.data.data_sources.category.room.entites;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


//@Entity(
//        foreignKeys = @ForeignKey(entity = AddPlant.class,
//                parentColumns = "id",
//                childColumns = "idcateg",
//                onDelete = ForeignKey.CASCADE),
//        primaryKeys = {"idcategori", "plantid"})
//public class NapPlant {
//
//    @PrimaryKey(autoGenerate = true)
//    public int plantid;
//
//    @NonNull
//    @ColumnInfo(name = "idcateg")
//    public int idcateg;
//
//    @NonNull
//    @ColumnInfo(name = "plantname")
//    public String plantname;
//
//    @ColumnInfo
//    public String image;
//
//    @ColumnInfo
//    public long time;
//
//    @NonNull
//    @ColumnInfo(name = "nameimage")
//    public String nameimage;
//
//    public int getPlantid() {
//        return plantid;
//    }
//
//    public int getIdcateg() {
//        return idcateg;
//    }
//
//    @NonNull
//    public String getPlantname() {
//        return plantname;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public long getTime() {
//        return time;
//    }
//
//
//    public NapPlant() {
//    }
//
//    @NonNull
//    public String getNameimage() {
//        return nameimage;
//    }
//
//
//
//    public NapPlant(int idcateg, String plantname, long time, String image) {
//        this.idcateg = idcateg;
//        this.plantname = plantname;
//        this.time = time;
//        this.image = image;
//    }
//
//    public NapPlantModel toDomainModel() {
//        return new NapPlantModel(idcateg, plantname, time, image);
//    }
//}
