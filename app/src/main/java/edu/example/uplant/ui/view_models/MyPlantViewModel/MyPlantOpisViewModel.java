package edu.example.uplant.ui.view_models.MyPlantViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.MyPlantNewCartochkaRepository;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.MyPlantOpisRepository;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;

public class MyPlantOpisViewModel extends AndroidViewModel {
    private MyPlantOpisRepository mRepository;
    private final LiveData<List<MyPlant>> mAllWords;
    public MyPlantOpisViewModel(@NonNull Application application, String name) {
        super(application);
        try {
            mRepository = new MyPlantOpisRepository(application, name);
            mAllWords = mRepository.getplants();
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<MyPlant>> getAllWords() { return mAllWords; }
}
