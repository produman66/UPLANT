package edu.example.uplant.data.data_sources.category.room.entites;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import edu.example.uplant.data.data_sources.category.models.PlantModel;
import edu.example.uplant.data.data_sources.category.models.UserModel;

@Entity(tableName = "users", indices = {@Index(value = {"email"}, unique = true)})
public class Users {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "pass")
    public String pass;


    public Users() {}

    public Users(@NonNull String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public UserModel toDomainModel() {
        return new UserModel(email, pass);
    }



}
