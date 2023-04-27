package edu.example.uplant.ui.adapters.SpravochnikAdapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.room.entites.Plant;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.PlantViewHolder;

public class PlantListAdapter extends ListAdapter<Plant, PlantViewHolder> {
    private CustomerClickListener listener;
    public PlantListAdapter(@NonNull DiffUtil.ItemCallback<Plant> diffCallback, CustomerClickListener listener) {
        super(diffCallback);
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PlantViewHolder.create(parent, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Plant current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
        holder.bind(current.getWord(), current.getImage1());
    }

    public static class PlantDiff extends DiffUtil.ItemCallback<Plant> {
        @Override
        public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem.getWord().equals(newItem.getWord());
        }
    }
}
