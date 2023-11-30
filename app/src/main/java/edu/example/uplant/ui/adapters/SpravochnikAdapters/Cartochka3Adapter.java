package edu.example.uplant.ui.adapters.SpravochnikAdapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.Cartochka3ViewHolder;

public class Cartochka3Adapter extends ListAdapter<MyPlantModel, Cartochka3ViewHolder> {

public Cartochka3Adapter(@NonNull DiffUtil.ItemCallback<MyPlantModel> diffCallback) {
        super(diffCallback);
        }

@NonNull
@Override
public Cartochka3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return Cartochka3ViewHolder.create1(parent);
        }

@Override
public void onBindViewHolder(@NonNull Cartochka3ViewHolder holder, int position) {
        MyPlantModel current = getItem(position);
        holder.bind1(current.getPlantname(), current.getNameimage(), current.getPeresadka());
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
