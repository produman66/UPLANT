package edu.example.uplant.ui.view_models.SpravochnikViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.room.entites.Plant;
import edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository.PlantRepository;

public class PlantViewModel extends AndroidViewModel {

    private PlantRepository mRepository;

    private final LiveData<List<Plant>> mAllWords;

    public PlantViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PlantRepository(application);
        mAllWords = mRepository.getAllWords();
    }
    public LiveData<List<Plant>> getAllWords() { return mAllWords; }
}
