package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.MyPlantAddRepository;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.UpdateMyPlantRepository;

public class UpdateMyPlantViewModel extends AndroidViewModel {
    private UpdateMyPlantRepository mRepository;

    public UpdateMyPlantViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UpdateMyPlantRepository(application);
    }
    public void editPlant(int id, String name, String desc, String poliv, String peresad, String udobr, String zam, String nameimage) {
        mRepository.editPlant(id, name, desc, poliv, peresad, udobr, zam, nameimage);
    }
    public void deletePlant(int id) {
        mRepository.deletePlant(id);
    }

}
