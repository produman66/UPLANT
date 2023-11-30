package edu.example.uplant.ui.adapters.SpravochnikAdapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.MyPlantViewHolder;

public class MyPlantListAdapter extends ListAdapter<MyPlantModel, MyPlantViewHolder> {

    private CustomerClickListener listener;

    public MyPlantListAdapter(@NonNull DiffUtil.ItemCallback<MyPlantModel> diffCallback, CustomerClickListener listener) {
        super(diffCallback);
        this.listener = listener;
    }
    @NonNull
    @Override
    public MyPlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyPlantViewHolder.create(parent, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlantViewHolder holder, int position) {
        MyPlantModel current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
        holder.bind(current.getPlantname(), current.getNameimage());
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
