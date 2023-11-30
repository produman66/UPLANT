package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;
import edu.example.uplant.data.data_sources.category.repositories.AddPlantRepository1;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;


public class UpdateMyPlantViewModel extends AndroidViewModel {
    private AddPlantRepository1 mRepository;

    public UpdateMyPlantViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AddPlantRepository1(application);
    }
    public void editPlant(int id, String name, String desc, String poliv, String peresad, String udobr, String zam, String nameimage) {
        mRepository.editPlant(id, name, desc, poliv, peresad, udobr, zam, nameimage);
    }
    public void deletePlant(int id) {
        mRepository.deletePlant(id);
    }

    public LiveData<List<AddPlantModel>> getPlant(String email) {
        return mRepository.allPlant(email);
    }


}
