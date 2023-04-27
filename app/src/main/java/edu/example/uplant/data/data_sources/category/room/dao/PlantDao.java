package edu.example.uplant.data.data_sources.category.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.entites.Plant;
@Dao
public interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Plant plant);

    @Query("DELETE FROM plant_categ_table")
    void deleteAll();

    @Query("SELECT * FROM plant_categ_table ORDER BY plant ASC")
    LiveData<List<Plant>> getAlphabetizedWords();

}
