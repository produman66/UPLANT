package edu.example.uplant.ui.view_models.MyPlantViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.PagerMyPlantRepository;
import edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository.CartochkaRepository;
import edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository.MyPlantRepository;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.ui.view.MyPlantUI.PagerMyPlant;

public class PagerMyPlantViewModel extends AndroidViewModel {
    private PagerMyPlantRepository mRepository;
    private final LiveData<List<AddPlant>> mAllWords;
    public PagerMyPlantViewModel(@NonNull Application application, int id) {
        super(application);
        try {
            mRepository = new PagerMyPlantRepository(application, id);
            mAllWords = mRepository.getplants();
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<AddPlant>> getAllWords() { return mAllWords; }
}
