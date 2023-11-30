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

    @Query("SELECT COUNT(*) FROM MyPlant WHERE idemail = :email AND plantname =:name")
    int checkEmailExists(String email, String name);


    @Query("SELECT * FROM MyPlant WHERE idcateg = :idcategori AND idemail=:idemail")
    LiveData<List<MyPlant>> loadMyPlantsByCategoryId(int idcategori, String idemail);

    @Query("SELECT * FROM MyPlant WHERE plantname = :name AND idemail = :idemail")
    LiveData<List<MyPlant>>  MyPlantVibor(String name, String idemail);

    @Query("UPDATE MyPlant SET favorite = NOT favorite WHERE plantname = :nameValue AND idemail = :email")
    void toggleBooleanValue(String nameValue, String email);

    @Query("SELECT * FROM MyPlant WHERE favorite = 1 AND idemail=:email")
    LiveData<List<MyPlant>> getMyPlantWithMTrue(String email);

    @Query("SELECT * FROM MyPlant WHERE plantname LIKE :searchQuery AND idemail = :email")
    LiveData<List<MyPlant>> searchDatabase(String searchQuery, String email);


}
