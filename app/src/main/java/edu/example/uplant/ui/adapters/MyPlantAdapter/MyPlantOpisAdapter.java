package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantNewCartochkaViewHolder;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantOpisViewHolder;

public class MyPlantOpisAdapter extends ListAdapter<MyPlant, MyPlantOpisViewHolder> {


    public MyPlantOpisAdapter(@NonNull DiffUtil.ItemCallback<MyPlant> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyPlantOpisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyPlantOpisViewHolder.create1(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlantOpisViewHolder holder, int position) {
        MyPlant current = getItem(position);
        holder.bind1(current.getmWord1(), current.getNameimage(), current.getDescrplant(), current.getPolivplant(), current.getPeresadkaplant(), current.getUdobrplant());
    }

    public static class PlantDiff extends DiffUtil.ItemCallback<MyPlant> {
        @Override
        public boolean areItemsTheSame(@NonNull MyPlant oldItem, @NonNull MyPlant newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MyPlant oldItem, @NonNull MyPlant newItem) {
            return oldItem.getmWord1().equals(newItem.getmWord1());
        }
    }
}
