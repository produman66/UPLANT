package edu.example.uplant.ui.adapters.FavoriteAdapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.FavoriteViewHolder.FavoriteViewHolder;

public class FavoriteAdapter extends ListAdapter<MyPlant, FavoriteViewHolder> {

    private CustomerClickListener listener;

    public FavoriteAdapter(@NonNull DiffUtil.ItemCallback<MyPlant> diffCallback, CustomerClickListener listener) {
        super(diffCallback);
        this.listener = listener;
    }
    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return FavoriteViewHolder.create(parent, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        MyPlant current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
        holder.bind(current.getmWord1(), current.getNameimage());
        holder.bind(current.getmWord1(), current.getNameimage());
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
