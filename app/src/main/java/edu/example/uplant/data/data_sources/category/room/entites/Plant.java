package edu.example.uplant.data.data_sources.category.room.entites;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "plant_categ_table")
public class Plant {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int getId() {
        return id;
    }

    @NonNull
    @ColumnInfo(name = "plant")
    public String mWord;

    @NonNull
    @ColumnInfo(name = "nameimage")
    public String nameimage;
    public Plant() {}

    @Ignore
    ImageView image;

    public Plant( int id, @NonNull String word, @NonNull String nameimage) {
        this.id = id; this.mWord = word; this.nameimage = nameimage;}
    public String getWord(){return this.mWord;}
    public String getImage1() {return this.nameimage;}
}
