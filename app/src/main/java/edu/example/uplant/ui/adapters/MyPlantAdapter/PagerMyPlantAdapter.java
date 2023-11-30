package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.PagerMyPlantViewHolder;

public class PagerMyPlantAdapter extends ListAdapter<AddPlantModel, PagerMyPlantViewHolder> {

    public PagerMyPlantAdapter(@NonNull DiffUtil.ItemCallback<AddPlantModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PagerMyPlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PagerMyPlantViewHolder.create1(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerMyPlantViewHolder holder, int position) {
        AddPlantModel current = getItem(position);
        holder.bind1(current.getName(), current.getNameimage(), current.getDesc(), current.getZametky(), current.getPoliv(), current.getPeresad(), current.getUdobr());
    }
    public static class PlantDiff extends DiffUtil.ItemCallback<AddPlantModel> {
        @Override
        public boolean areItemsTheSame(@NonNull AddPlantModel oldItem, @NonNull AddPlantModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AddPlantModel oldItem, @NonNull AddPlantModel newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

}
