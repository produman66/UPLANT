package edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.dao.AddPlantDao;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class MyPlantAddRepository {

    private AddPlantDao mWordDao;
    private LiveData<List<AddPlant>> mAllWords;
    public MyPlantAddRepository(Application application) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.addplantDao();
        mAllWords = mWordDao.getAllAddPlants();
    }
    public LiveData<List<AddPlant>> getAllWords() {
        return mAllWords;
    }

}
