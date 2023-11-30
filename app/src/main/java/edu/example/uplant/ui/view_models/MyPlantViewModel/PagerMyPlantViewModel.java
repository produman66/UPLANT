package edu.example.uplant.ui.view_models.MyPlantViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.AddPlantRepository1;

public class PagerMyPlantViewModel extends AndroidViewModel {
    private AddPlantRepository1 mRepository;
    public PagerMyPlantViewModel(@NonNull Application application) {
        super(application);
        try {
            mRepository = new AddPlantRepository1(application);
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<AddPlantModel>> getAllWords(int id) {
        return mRepository.myPlantAddVibor(id);
    }
}
