package edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.dao.PlantDao;
import edu.example.uplant.data.data_sources.category.room.entites.Plant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class PlantRepository {
    private PlantDao mWordDao;
    private LiveData<List<Plant>> mAllWords;
    public PlantRepository(Application application) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.plantDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }
    public LiveData<List<Plant>> getAllWords() {
        return mAllWords;
    }
}
