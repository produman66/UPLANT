package edu.example.uplant.data.data_sources.category.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import edu.example.uplant.data.data_sources.category.room.ItemsDataSource;
import edu.example.uplant.data.data_sources.category.room.entites.ItemEntity;
import edu.example.uplant.data.data_sources.category.room.root.AppDatabase;
import edu.example.uplant.data.data_sources.category.models.Item;

public class ItemsRepository {
    private ItemsDataSource mDataSource;
    private AppDatabase databaseSource;

    public ItemsRepository(Application application) {
        this.mDataSource = new ItemsDataSource();
        this.databaseSource = AppDatabase.getDatabase(application);
        for (int i = 0; i < 5; i++) {
            addItem(new Item("Roza" + (i + 1)));
        }

    }
    public LiveData<List<Item>> getData() {
        return mDataSource.items();
    }
    public LiveData<List<Item>> getDatabaseData() {
        return Transformations.map(
                databaseSource.itemDAO().getAllItems(),
                (values) -> values.stream().map(ItemEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addItem(Item newItem) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.itemDAO().addNewItem(new ItemEntity(newItem.getValue()));
        });
    }
}