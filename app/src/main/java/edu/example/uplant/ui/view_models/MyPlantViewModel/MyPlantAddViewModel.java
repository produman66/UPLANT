package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.MyPlantAddRepository;
import edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository.PlantRepository;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.entites.Plant;

public class MyPlantAddViewModel extends AndroidViewModel {
    private MyPlantAddRepository mRepository;

    private final LiveData<List<AddPlant>> mAllWords;

    public MyPlantAddViewModel(@NonNull Application application) {
        super(application);
        mRepository = new MyPlantAddRepository(application);
        mAllWords = mRepository.getAllWords();
    }
    public LiveData<List<AddPlant>> getAllWords() { return mAllWords; }
}
