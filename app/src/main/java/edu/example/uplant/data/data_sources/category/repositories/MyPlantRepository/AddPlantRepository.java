package edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import edu.example.uplant.data.data_sources.category.models.AddPlant1;
import edu.example.uplant.data.data_sources.category.models.Item;
import edu.example.uplant.data.data_sources.category.room.dao.AddPlantDao;
import edu.example.uplant.data.data_sources.category.room.dao.PlantsWithMyPlants;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.entites.ItemEntity;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.data.data_sources.category.room.root.AppDatabase;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class AddPlantRepository {
    private AddPlantDao mWordDao;
    private PlantRoomDatabase databaseSource;

    public AddPlantRepository(Application application, String name, String desc, String poliv, String peresad, String udobr, String nameimage, String zametky) {
        databaseSource = PlantRoomDatabase.getDatabase(application);
        mWordDao = databaseSource.addplantDao();
    }

    public LiveData<List<AddPlant1>> getDatabaseData() {
        return Transformations.map(
                databaseSource.addplantDao().getAllAddPlants(),
                (values) -> values.stream().map(AddPlant::toDomainMode).collect(Collectors.toList())
        );
    }
    public void addPlant(AddPlant newplant) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.addplantDao().insert(new AddPlant(newplant.getName(), newplant.getDesc(), newplant.getPoliv(), newplant.getPeresad(), newplant.getUdobr(), newplant.getNameimage(), newplant.getZametky()));
        });
    }
}
