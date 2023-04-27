package edu.example.uplant.data.data_sources.category.repositories.MyPlantRepository;

import android.app.Application;

import edu.example.uplant.data.data_sources.category.room.dao.AddPlantDao;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;

public class UpdateMyPlantRepository {
    private AddPlantDao mWordDao;

    private PlantRoomDatabase databaseSource;

    public UpdateMyPlantRepository(Application application) {
        this.databaseSource = PlantRoomDatabase.getDatabase(application);
    }
    public void editPlant(int id, String name, String desc, String poliv, String peresad, String udobr, String zam, String nameimage) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.addplantDao().updatePlant(id, name, desc, poliv, peresad, udobr, zam, nameimage);
        });
    }
    public void deletePlant(int id) {
        PlantRoomDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.addplantDao().deletePlant(id);
        });
    }

}
