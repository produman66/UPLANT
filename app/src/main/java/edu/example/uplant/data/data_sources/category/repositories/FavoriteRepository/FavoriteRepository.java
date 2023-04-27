package edu.example.uplant.data.data_sources.category.repositories.FavoriteRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;
import edu.example.uplant.data.data_sources.category.room.dao.PlantsWithMyPlants;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;

public class FavoriteRepository {
    private PlantsWithMyPlants mWordDao;
    private LiveData<List<MyPlant>> mAllWords;
    public FavoriteRepository(Application application) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.myplantDao();
        mAllWords = mWordDao.getMyPlantWithMTrue();
    }
    public LiveData<List<MyPlant>> getAllWords() {
        return mAllWords;
    }
}
