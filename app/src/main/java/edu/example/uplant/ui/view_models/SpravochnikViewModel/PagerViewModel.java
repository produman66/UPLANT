package edu.example.uplant.ui.view_models.SpravochnikViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository.PagerRepository;

public class PagerViewModel extends AndroidViewModel {
    private PagerRepository mRepository;
    public PagerViewModel(@NonNull Application application, String name) {
        super(application);
        try {
            mRepository = new PagerRepository(application, name);
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }

    public void onFavoriteButtonClicked(String plantName) {
        mRepository.toggleBooleanValue(plantName);
    }
}
