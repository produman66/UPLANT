package edu.example.uplant.ui.adapters.SpravochnikAdapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.Cartochka7ViewHolder;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.Cartochka8ViewHolder;

public class Cartochka8Adapter extends ListAdapter<MyPlantModel, Cartochka8ViewHolder> {

    public Cartochka8Adapter(@NonNull DiffUtil.ItemCallback<MyPlantModel> diffCallback) {
        super(diffCallback);
    }
    @NonNull
    @Override
    public Cartochka8ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return Cartochka8ViewHolder.create1(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull Cartochka8ViewHolder holder, int position) {
        MyPlantModel current = getItem(position);
        holder.bind1(current.getPlantname(), current.getNameimage(), current.getSvet());
    }
    public static class PlantDiff extends DiffUtil.ItemCallback<MyPlantModel> {
        @Override
        public boolean areItemsTheSame(@NonNull MyPlantModel oldItem, @NonNull MyPlantModel newItem) {
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame(@NonNull MyPlantModel oldItem, @NonNull MyPlantModel newItem) {
            return oldItem.getPlantname().equals(newItem.getPlantname());
        }
    }
}