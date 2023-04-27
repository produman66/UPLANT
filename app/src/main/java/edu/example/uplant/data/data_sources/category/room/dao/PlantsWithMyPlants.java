package edu.example.uplant.data.data_sources.category.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;

@Dao
public interface PlantsWithMyPlants {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MyPlant myplant);

    @Query("DELETE FROM plant_categ_table")
    void deleteAll();

    @Query("SELECT * FROM MyPlant WHERE idcategori = :idcategori")
    LiveData<List<MyPlant>> loadMyPlantsByCategoryId(int idcategori);

    @Query("SELECT * FROM MyPlant WHERE plantname = :name")
    LiveData<List<MyPlant>>  MyPlantVibor(String name);

    @Query("UPDATE MyPlant SET favorite = NOT favorite WHERE plantname = :nameValue")
    void toggleBooleanValue(String nameValue);

    @Query("SELECT * FROM MyPlant WHERE favorite = 1")
    LiveData<List<MyPlant>> getMyPlantWithMTrue();


}
