package edu.example.uplant.data.data_sources.category.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.models.PlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.NapPlant;
import edu.example.uplant.data.data_sources.category.room.entites.Plant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;



//Репозиторий для работы с категориями
public class PlantCategoryRepository {
    private PlantRoomDatabase database;


    public PlantCategoryRepository(Application application) {
        this.database = PlantRoomDatabase.getDatabase(application);
    }




    //Получаетс список всех категории растений
    public LiveData<List<PlantModel>> getDatabaseDataPlant() {
        return Transformations.map(
                database.plantDao().getAllPlants(),
                (values) -> values.stream().map(Plant::toDomainModel).collect(Collectors.toList())
        );
    }

}
