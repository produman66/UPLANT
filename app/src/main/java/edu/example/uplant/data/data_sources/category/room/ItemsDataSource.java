package edu.example.uplant.data.data_sources.category.room;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import edu.example.uplant.data.data_sources.category.models.Item;

public class ItemsDataSource {
    public LiveData<List<Item>> items() {
        MutableLiveData<List<Item>> result = new MutableLiveData<>();

        new Thread(() -> {
            ArrayList<Item> resultArr = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                resultArr.add(new Item("Roza" + (i + 1)));

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result.postValue(resultArr);
        }).start();
        return result;
    }
}
