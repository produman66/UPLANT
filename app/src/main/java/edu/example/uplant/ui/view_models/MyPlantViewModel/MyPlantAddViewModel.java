package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


import edu.example.uplant.data.data_sources.category.repositories.MyPlantAddRepository;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;

public class MyPlantAddViewModel extends AndroidViewModel {
    private MyPlantAddRepository mRepository;

    private final LiveData<List<AddPlant>> mAllWords;
    private final LiveData<List<AddPlant>> mUserWords;

    public MyPlantAddViewModel(@NonNull Application application, String email) {
        super(application);
        mRepository = new MyPlantAddRepository(application, email);
        mAllWords = mRepository.getAllWords();
        mUserWords = mRepository.getAllUserWords();
    }
    public LiveData<List<AddPlant>> getAllWords() { return mAllWords; }
    public LiveData<List<AddPlant>> getUserWords() { return mUserWords; }

}
