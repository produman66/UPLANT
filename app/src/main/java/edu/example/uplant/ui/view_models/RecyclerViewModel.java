package edu.example.uplant.ui.view_models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.example.uplant.data.data_sources.category.models.Item;
import edu.example.uplant.data.data_sources.category.repositories.ItemsRepository;

public class RecyclerViewModel extends AndroidViewModel {
    private ItemsRepository repo;

    private LiveData<List<Item>> mItems;

    public RecyclerViewModel(Application application) {
        super(application);
        this.repo = new ItemsRepository(application);
        mItems = repo.getDatabaseData();
    }
    public LiveData<List<Item>> getItems() {
        return mItems;
    }
    public void addItem() {
        repo.addItem(new Item("roza"));
    }
}
