package edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.dao.AddPlantDao;
import edu.example.uplant.data.data_sources.category.room.dao.PlantsWithMyPlants;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class PagerMyPlantRepository {
    private AddPlantDao mWordDao;
    private LiveData<List<AddPlant>> mAllWords;
    public PagerMyPlantRepository(Application application, int id) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.addplantDao();
        mAllWords = mWordDao.MyPlantAddVibor(id);
    }
    public LiveData<List<AddPlant>>getplants() {
        return mAllWords;
    }
}
