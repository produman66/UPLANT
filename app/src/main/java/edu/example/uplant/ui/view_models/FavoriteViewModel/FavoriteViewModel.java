package edu.example.uplant.ui.view_models.FavoriteViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.repositories.FavoriteRepository.FavoriteRepository;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;

public class FavoriteViewModel extends AndroidViewModel {
    private FavoriteRepository mRepository;
    private final LiveData<List<MyPlant>> mAllWords;
    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        try {
            mRepository = new FavoriteRepository(application);
            mAllWords = mRepository.getAllWords();
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<MyPlant>> getAllWords() { return mAllWords; }

}
