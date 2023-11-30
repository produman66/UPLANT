package edu.example.uplant.data.data_sources.category.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.NapPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class NapPlantRepository {

    private PlantRoomDatabase databaseSource;

    public NapPlantRepository(Application application) {
        this.databaseSource = PlantRoomDatabase.getDatabase(application);
    }

    public LiveData<List<NapPlantModel>> getDatabaseDataTodo(int id) {
        return Transformations.map(
                databaseSource.napplantDao().getTodoById(id),
                (values) -> values.stream().map(NapPlant::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addTodo(NapPlantModel newNapPlant) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.napplantDao().addNewTodo(new NapPlant(newNapPlant.getIdemail(),   newNapPlant.getIdcateg(), newNapPlant.getPlantname(), newNapPlant.getDesc(), newNapPlant.getTime()));
        });
    }

    public LiveData<List<NapPlantModel>> getDatabaseDataAllTodo() {
        return Transformations.map(
                databaseSource.napplantDao().getAllTodo(),
                (values) -> values.stream().map(NapPlant::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<NapPlantModel>> getDatabaseDataEmail(String idemail) {
        return Transformations.map(
                databaseSource.napplantDao().getTodoByEmail(idemail),
                (values) -> values.stream().map(NapPlant::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<NapPlantModel>> getPlantTodo(int id) {
        return Transformations.map(
                databaseSource.napplantDao().getPlantTodo(id),
                (values) -> values.stream().map(NapPlant::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<NapPlantModel>> getInfoTodo(int id) {
        return Transformations.map(
                databaseSource.napplantDao().getInfoTodo(id),
                (values) -> values.stream().map(NapPlant::toDomainModel).collect(Collectors.toList())
        );
    }

    public void deleteTodo(int id) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.napplantDao().deleteTodoByID(id);
        });
    }
}
