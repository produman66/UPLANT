package edu.example.uplant.ui.view_models.SpravochnikViewModel;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

public class MyPlantViewModel extends AndroidViewModel {

    private MyPlantRepository mRepository;

    private final LiveData<List<MyPlantModel>> mAllWords;
    private LiveData<List<MyPlantModel>> Search;

    public MyPlantViewModel(@NonNull Application application, int categoryId, String idemail) {
        super(application);
        try {
            mRepository = new MyPlantRepository(application);
            mAllWords = mRepository.getById(categoryId, idemail);
        } catch (Exception e) {
            // обработка исключения
            Log.e(TAG, "Error while creating MyPlantViewModel object", e);
            throw new RuntimeException("Error while creating MyPlantViewModel object", e);
        }
    }
    public LiveData<List<MyPlantModel>> getAllWords() { return mAllWords; }

    public LiveData<List<MyPlantModel>> getSearch(String name, String email) {
        return mRepository.searchDatabase(name, email); }


}
