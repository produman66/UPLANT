package edu.example.uplant.ui.view_models.MyPlantViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.AddPlant1;
import edu.example.uplant.data.data_sources.category.models.Item;
import edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository.AddPlantRepository;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;

public class AddPlantViewModel extends AndroidViewModel {
    private AddPlantRepository repo;
    private LiveData<List<AddPlant1>> mItems;

    public AddPlantViewModel(Application application, String name, String desc, String poliv, String peresad, String udobr, String nameimage, String zametky) {
        super(application);
        this.repo = new AddPlantRepository(application, name, desc, poliv, peresad, udobr, nameimage, zametky);
        mItems = repo.getDatabaseData();
    }
    public LiveData<List<AddPlant1>> getItems() {
        return mItems;
    }
    public void addPlant(String name, String desc, String poliv, String peresad, String udobr, String nameimage, String zametky) {
        repo.addPlant(new AddPlant(name, desc, poliv, peresad, udobr, nameimage, zametky));
    }
}
