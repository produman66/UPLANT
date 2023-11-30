package edu.example.uplant.data.data_sources.category.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import edu.example.uplant.data.data_sources.category.models.MomentModel;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.Moment;
import edu.example.uplant.data.data_sources.category.room.entites.NapPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class MomentRepository {

    private PlantRoomDatabase databaseSource;

    public MomentRepository(Application application) {
        this.databaseSource = PlantRoomDatabase.getDatabase(application);
    }


    public LiveData<List<MomentModel>> getInfoMoment(int id) {
        return Transformations.map(
                databaseSource.momentDao().getInfoMoment(id),
                (values) -> values.stream().map(Moment::toDomainModel).collect(Collectors.toList())
        );
    }


    public void addMoment(MomentModel newMoment) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.momentDao().addNewMoment(new Moment(newMoment.getIdcateg(), newMoment.getDate(), newMoment.getTime(), newMoment.getDesc(), newMoment.getUrl()));
        });
    }

    public LiveData<List<MomentModel>> getPlantMoment(int idcateg) {
        return Transformations.map(
                databaseSource.momentDao().getMomentById(idcateg),
                (values) -> values.stream().map(Moment::toDomainModel).collect(Collectors.toList())
        );
    }

    public void deleteMoment(int id) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.momentDao().deleteMomentById(id);
        });
    }



}
