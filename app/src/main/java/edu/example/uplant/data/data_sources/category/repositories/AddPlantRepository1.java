package edu.example.uplant.data.data_sources.category.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class AddPlantRepository1 {

    private PlantRoomDatabase database;

    public AddPlantRepository1(Application application) {
        this.database = PlantRoomDatabase.getDatabase(application);
    }

    public LiveData<List<AddPlantModel>> getDatabaseData() {
        return Transformations.map(
                database.addplantDao().getAllAddPlants(),
                (values) -> values.stream().map(AddPlant::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addPlant(AddPlantModel newplant) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            database.addplantDao().insert(new AddPlant(newplant.getIduser(), newplant.getName(), newplant.getDesc(), newplant.getPoliv(), newplant.getPeresad(), newplant.getUdobr(), newplant.getNameimage(), newplant.getZametky()));
        });
    }

    public LiveData<List<AddPlantModel>> myPlantAddVibor(int id){
        return Transformations.map(
                database.addplantDao().MyPlantAddVibor(id),
                (values) -> values.stream().map(AddPlant::toDomainModel).collect(Collectors.toList())
        );
    }

    public void editPlant(int id, String name, String desc, String poliv, String peresad, String udobr, String zam, String nameimage) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            database.addplantDao().updatePlant(id, name, desc, poliv, peresad, udobr, zam, nameimage);
        });
    }
    public void deletePlant(int id) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            database.addplantDao().deletePlant(id);
        });
    }

    public LiveData<List<AddPlantModel>> allPlant(String email){
        return Transformations.map(
                database.addplantDao().getAllUserAddPlants(email),
                (values) -> values.stream().map(AddPlant::toDomainModel).collect(Collectors.toList())
        );
    }






}
