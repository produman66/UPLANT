package edu.example.uplant.data.data_sources.category.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.dao.AddPlantDao;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class MyPlantAddRepository {
    private AddPlantDao mWordDao;
    private LiveData<List<AddPlant>> mAllWords;
    private LiveData<List<AddPlant>> mUserWords;
    public MyPlantAddRepository(Application application, String email) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.addplantDao();
        mAllWords = mWordDao.getAllAddPlants();
        mUserWords = mWordDao.getAllUserAddPlants(email);

    }
    public LiveData<List<AddPlant>> getAllWords() {
        return mAllWords;
    }

    public LiveData<List<AddPlant>> getAllUserWords() {
        return mUserWords;
    }

}
