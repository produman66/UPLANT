package edu.example.uplant.data.data_sources.category.room.entites;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.models.NapPlantModel;


@Entity(
        foreignKeys = @ForeignKey(entity = AddPlant.class,
                parentColumns = "id",
                childColumns = "idcateg",
                onDelete = ForeignKey.CASCADE))
public class NapPlant {


    public String getIdemail() {
        return idemail;
    }

    public void setIdemail(String idemail) {
        this.idemail = idemail;
    }

    @PrimaryKey(autoGenerate = true)
    public int plantid;

    @NonNull
    @ColumnInfo(name = "idcateg")
    public int idcateg;

    @NonNull
    @ColumnInfo(name = "idemail")
    public String idemail;

    @NonNull
    @ColumnInfo(name = "plantname")
    public String plantname;

    @ColumnInfo
    public long time;

    public String getDesc() {
        return desc;
    }

    @ColumnInfo
    public String desc;

    public int getPlantid() {
        return plantid;
    }

    public int getIdcateg() {
        return idcateg;
    }

    @NonNull
    public String getPlantname() {
        return plantname;
    }


    public long getTime() {
        return time;
    }


    public NapPlant() {
    }
    public NapPlant(String idemail, int idcateg, String plantname, String desc, long time) {
        this.idemail=idemail;
        this.idcateg = idcateg;
        this.plantname = plantname;
        this.time = time;
        this.desc = desc;
    }

    public NapPlantModel toDomainModel() {
        return new NapPlantModel(plantid, idemail, idcateg, plantname, desc, time);
    }
}
