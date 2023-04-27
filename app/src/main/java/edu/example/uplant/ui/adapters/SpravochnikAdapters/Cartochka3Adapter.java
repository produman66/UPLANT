package edu.example.uplant.ui.adapters.SpravochnikAdapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.Cartochka3ViewHolder;

public class Cartochka3Adapter extends ListAdapter<MyPlant, Cartochka3ViewHolder> {

public Cartochka3Adapter(@NonNull DiffUtil.ItemCallback<MyPlant> diffCallback) {
        super(diffCallback);
        }

@NonNull
@Override
public Cartochka3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return Cartochka3ViewHolder.create1(parent);
        }

@Override
public void onBindViewHolder(@NonNull Cartochka3ViewHolder holder, int position) {
        MyPlant current = getItem(position);
        holder.bind1(current.getmWord1(), current.getNameimage(), current.getPeresadka());
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
