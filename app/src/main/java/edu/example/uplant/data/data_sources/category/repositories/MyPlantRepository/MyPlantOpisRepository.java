package edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.dao.PlantsWithMyPlants;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class MyPlantOpisRepository {
    private PlantsWithMyPlants mWordDao;
    private LiveData<List<MyPlant>> mAllWords;
    public MyPlantOpisRepository(Application application, String name) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.myplantDao();
        mAllWords = mWordDao.MyPlantVibor(name);
    }
    public LiveData<List<MyPlant>>getplants() {
        return mAllWords;
    }
}
