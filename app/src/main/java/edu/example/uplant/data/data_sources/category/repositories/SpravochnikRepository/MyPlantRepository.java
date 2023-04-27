package edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;
import edu.example.uplant.data.data_sources.category.room.dao.PlantsWithMyPlants;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;

public class MyPlantRepository {
    private PlantsWithMyPlants mWordDao;
    private LiveData<List<MyPlant>> mAllWords;
    public MyPlantRepository(Application application, int id) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.myplantDao();
        mAllWords = mWordDao.loadMyPlantsByCategoryId(id);
    }
    public LiveData<List<MyPlant>> getAllWords() {
        return mAllWords;
    }
}
