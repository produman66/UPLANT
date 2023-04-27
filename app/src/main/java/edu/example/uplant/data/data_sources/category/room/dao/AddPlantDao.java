package edu.example.uplant.data.data_sources.category.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.AddPlant1;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.data.data_sources.category.room.entites.Plant;


@Dao
public interface AddPlantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AddPlant plant);

    @Query("SELECT * FROM plant_add ORDER BY plant ASC")
    LiveData<List<AddPlant>> getAllAddPlants();

    @Query("SELECT * FROM plant_add WHERE id = :id")
    LiveData<List<AddPlant>>  MyPlantAddVibor(int id);


    @Query("UPDATE plant_add SET plant = :name, poliv = :poliv, descr=:desc, peresad= :perec, udobr = :udobr, zametky=:zam, nameimage=:nameimage WHERE id = :id")
    void updatePlant(int id, String name, String desc, String poliv, String perec, String udobr, String zam, String nameimage);

    @Query("DELETE from plant_add WHERE id = :id")
    void deletePlant(int id);

}
