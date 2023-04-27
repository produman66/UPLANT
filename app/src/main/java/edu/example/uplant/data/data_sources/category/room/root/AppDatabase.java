package edu.example.uplant.data.data_sources.category.room.root;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.example.uplant.data.data_sources.category.room.dao.ItemDAO;
import edu.example.uplant.data.data_sources.category.room.entites.ItemEntity;

@Database(entities = {ItemEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO itemDAO();

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_d")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}