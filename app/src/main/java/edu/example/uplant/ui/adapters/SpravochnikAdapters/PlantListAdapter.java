package edu.example.uplant.ui.adapters.SpravochnikAdapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.PlantModel;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.PlantViewHolder;

public class PlantListAdapter extends ListAdapter<PlantModel, PlantViewHolder> {
    private CustomerClickListener listener;
    public PlantListAdapter(@NonNull DiffUtil.ItemCallback<PlantModel> diffCallback, CustomerClickListener listener) {
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
        PlantModel current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
        holder.bind(current.getName(), current.getNameimage());
    }

    public static class PlantDiff extends DiffUtil.ItemCallback<PlantModel> {
        @Override
        public boolean areItemsTheSame(@NonNull PlantModel oldItem, @NonNull PlantModel newItem) {
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame(@NonNull PlantModel oldItem, @NonNull PlantModel newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
