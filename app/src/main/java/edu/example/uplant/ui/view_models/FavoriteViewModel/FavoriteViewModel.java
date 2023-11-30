package edu.example.uplant.ui.view_models.FavoriteViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

public class FavoriteViewModel extends AndroidViewModel {
    private MyPlantRepository mRepository;
    private LiveData<List<MyPlantModel>> favPlant;
    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        try {
            mRepository = new MyPlantRepository(application);
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<MyPlantModel>> getFav(String email){
        favPlant = mRepository.AllPlantFavorite(email);
        return favPlant;
    }



}
