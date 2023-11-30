package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;

import edu.example.uplant.data.data_sources.category.repositories.AddPlantRepository1;

public class AddPlantViewModel extends AndroidViewModel {
    private AddPlantRepository1 repo;
    private LiveData<List<AddPlantModel>> mItems;

    public AddPlantViewModel(Application application) {
        super(application);
        this.repo = new AddPlantRepository1(application);
        mItems = repo.getDatabaseData();
    }

    public void addPlant(int id, String idUser, String name, String desc, String poliv, String peresad, String udobr, String nameimage, String zametky) {
        repo.addPlant(new AddPlantModel(id, idUser, name, desc, poliv, peresad, udobr, nameimage, zametky));
    }
}
