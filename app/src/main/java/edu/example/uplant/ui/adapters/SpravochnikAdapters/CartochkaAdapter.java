package edu.example.uplant.ui.adapters.SpravochnikAdapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.CartochkaViewHolder;

public class CartochkaAdapter extends ListAdapter<MyPlant, CartochkaViewHolder> {


    public CartochkaAdapter(@NonNull DiffUtil.ItemCallback<MyPlant> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CartochkaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CartochkaViewHolder.create1(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CartochkaViewHolder holder, int position) {
        MyPlant current = getItem(position);
        holder.bind1(current.getmWord1(), current.getNameimage(), current.getDescr());
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
