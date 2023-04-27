package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.AddPlant1;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantAddViewHolder;

public class MyPlantAddAdapter extends ListAdapter<AddPlant, MyPlantAddViewHolder> {

    private CustomerClickListener listener;

    public MyPlantAddAdapter(@NonNull DiffUtil.ItemCallback<AddPlant> diffCallback, CustomerClickListener listener) {
        super(diffCallback);
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyPlantAddViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyPlantAddViewHolder.create(parent, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlantAddViewHolder holder, int position) {
        AddPlant current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
        holder.bind(current.getName(), current.getNameimage());
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
