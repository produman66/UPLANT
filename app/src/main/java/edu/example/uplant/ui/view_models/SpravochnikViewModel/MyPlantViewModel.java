package edu.example.uplant.ui.view_models.SpravochnikViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository.MyPlantRepository;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;

public class MyPlantViewModel extends AndroidViewModel {
    private MyPlantRepository mRepository;
    private final LiveData<List<MyPlant>> mAllWords;
    public MyPlantViewModel(@NonNull Application application, int categoryId) {
        super(application);
        try {
            mRepository = new MyPlantRepository(application, categoryId);
            mAllWords = mRepository.getAllWords();
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<MyPlant>> getAllWords() { return mAllWords; }
}
