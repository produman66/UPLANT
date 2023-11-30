package edu.example.uplant.data.data_sources.category.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.entites.Moment;
import edu.example.uplant.data.data_sources.category.room.entites.NapPlant;

@Dao
public interface MomentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addNewMoment(Moment moment);

    @Query("SELECT * FROM Moment WHERE idcateg = :idcategori ORDER BY time")
    LiveData<List<Moment>> getMomentById(int idcategori);

    @Query("SELECT * FROM Moment WHERE id = :id  ORDER BY time")
    LiveData<List<Moment>> getInfoMoment(int id);

    @Query("DELETE from Moment WHERE id = :id")
    void deleteMomentById(int id);
}
