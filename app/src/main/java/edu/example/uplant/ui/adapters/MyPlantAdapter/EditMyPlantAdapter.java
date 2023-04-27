package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.EditMyPlantViewHolder;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.PagerMyPlantViewHolder;

public class EditMyPlantAdapter extends ListAdapter<AddPlant, EditMyPlantViewHolder> {

    public EditMyPlantAdapter(@NonNull DiffUtil.ItemCallback<AddPlant> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public EditMyPlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return EditMyPlantViewHolder.create1(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull EditMyPlantViewHolder holder, int position) {
        AddPlant current = getItem(position);
        holder.bind1(current.getName(), current.getNameimage(), current.getDesc(), current.getZametky(), current.getPoliv(), current.getPeresad(), current.getUdobr());
    }
    public static class PlantDiff extends DiffUtil.ItemCallback<AddPlant> {
        @Override
        public boolean areItemsTheSame(@NonNull AddPlant oldItem, @NonNull AddPlant newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AddPlant oldItem, @NonNull AddPlant newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

}
