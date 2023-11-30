package edu.example.uplant.data.data_sources.category.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.data.data_sources.category.room.entites.NapPlant;

@Dao
public interface NapPlantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addNewTodo(NapPlant napplant);

    @Query("SELECT * FROM NapPlant WHERE idcateg = :idcategori ORDER BY time")
    LiveData<List<NapPlant>> getTodoById(int idcategori);

    @Query("SELECT * FROM NapPlant WHERE idemail = :idemail ORDER BY time")
    LiveData<List<NapPlant>> getTodoByEmail(String idemail);

    @Query("SELECT * FROM NapPlant ORDER BY time")
    LiveData<List<NapPlant>> getAllTodo();

    @Query("SELECT * FROM NapPlant WHERE plantid = :id  ORDER BY time")
    LiveData<List<NapPlant>> getInfoTodo(int id);

    @Query("SELECT * FROM NapPlant WHERE idcateg = :idcateg  ORDER BY time")
    LiveData<List<NapPlant>> getPlantTodo(int idcateg);

    @Query("SELECT * FROM NapPlant WHERE time < :currentTime")
    LiveData<List<NapPlant>> getNotifications(long currentTime);

    @Update
    void update(NapPlant napplant);

    @Query("DELETE from NapPlant WHERE plantid = :id")
    void deleteTodoByID(int id);
}
