package edu.example.uplant.data.data_sources.category.repositories.SpravochnikRepository;

import android.app.Application;
import android.os.AsyncTask;

import edu.example.uplant.data.data_sources.category.room.root.PlantRoomDatabase;
import edu.example.uplant.data.data_sources.category.room.dao.PlantsWithMyPlants;

public class PagerRepository {
    private PlantsWithMyPlants mWordDao;
    public PagerRepository(Application application, String name) {
        PlantRoomDatabase db = PlantRoomDatabase.getDatabase(application);
        mWordDao = db.myplantDao();
    }
    public void toggleBooleanValue(String nameValue) {
        new ToggleBooleanValueAsyncTask(mWordDao).execute(nameValue);
    }
    private static class ToggleBooleanValueAsyncTask extends AsyncTask<String, Void, Void> {
        private PlantsWithMyPlants mAsyncTaskDao;

        ToggleBooleanValueAsyncTask(PlantsWithMyPlants dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            String nameValue = params[0];
            mAsyncTaskDao.toggleBooleanValue(nameValue);
            return null;
        }
    }
}
