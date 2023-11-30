package edu.example.uplant.data.data_sources.category.room.entites;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.models.MomentModel;

@Entity(
        foreignKeys = @ForeignKey(entity = AddPlant.class,
                parentColumns = "id",
                childColumns = "idcateg",
                onDelete = ForeignKey.CASCADE))
public class Moment {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "idcateg")
    public int idcateg;

    @ColumnInfo
    public String date;

    @ColumnInfo
    public long time;

    @ColumnInfo
    public String desc;

    @ColumnInfo
    public String url;

    public Moment() {}

    public Moment(int idcateg, String date, long time, String desc, String url) {
        this.idcateg = idcateg;
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.url = url;
    }

    public MomentModel toDomainModel() {
        return new MomentModel(id, idcateg, desc, date, time, url);
    }

}
