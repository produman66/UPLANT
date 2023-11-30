package edu.example.uplant.ui.view_models.MyPlantViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

public class MyPlantNewCartochkaViewModel extends AndroidViewModel {
    private MyPlantRepository mRepository;
    public MyPlantNewCartochkaViewModel(@NonNull Application application) {
        super(application);
        try {
            mRepository = new MyPlantRepository(application);
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<MyPlantModel>> getAllWords(String name, String email) {
        return mRepository.PlantVibor(name, email);
    }
}
