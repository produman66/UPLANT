package edu.example.uplant.data.data_sources.category.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.entites.ItemEntity;

@Dao
public interface ItemDAO {
    @Query("SELECT * FROM ItemEntity")
    LiveData<List<ItemEntity>> getAllItems();

    @Insert
    void addNewItem(ItemEntity newItem);

    @Query("DELETE FROM ItemEntity")
    void deleteAll();
}