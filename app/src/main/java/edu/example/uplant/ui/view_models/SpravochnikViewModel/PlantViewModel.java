package edu.example.uplant.ui.view_models.SpravochnikViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.PlantModel;
import edu.example.uplant.data.data_sources.category.repositories.PlantCategoryRepository;

public class PlantViewModel extends AndroidViewModel {

    private PlantCategoryRepository mRepository;

    private final LiveData<List<PlantModel>> mAllWords;

    public PlantViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PlantCategoryRepository(application);
        mAllWords = mRepository.getDatabaseDataPlant();
    }
    public LiveData<List<PlantModel>> getAllWords() { return mAllWords; }
}
