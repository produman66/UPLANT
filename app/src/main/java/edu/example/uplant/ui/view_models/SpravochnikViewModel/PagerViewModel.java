package edu.example.uplant.ui.view_models.SpravochnikViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

public class PagerViewModel extends AndroidViewModel {
    private MyPlantRepository mRepository;

    public PagerViewModel(@NonNull Application application, String name) {
        super(application);
        try {
            mRepository = new MyPlantRepository(application);

        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }

    public void onFavoriteButtonClicked(String plantName, String email) {
        mRepository.ToggleBooleanValue(plantName, email);
    }

    public void newacc() {
        mRepository.NewAcc();
    }

}
