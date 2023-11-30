package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.AddPlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantAddViewHolder;

public class MyPlantAddAdapter extends ListAdapter<AddPlantModel, MyPlantAddViewHolder> {

    private CustomerClickListener listener;
    private ButtonClickListener btnlistener;

    public MyPlantAddAdapter(@NonNull DiffUtil.ItemCallback<AddPlantModel> diffCallback, CustomerClickListener listener, ButtonClickListener btnlistener) {
        super(diffCallback);
        this.listener = listener;
        this.btnlistener = btnlistener;
    }

    @NonNull
    @Override
    public MyPlantAddViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyPlantAddViewHolder.create(parent, listener, btnlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlantAddViewHolder holder, int position) {
        AddPlantModel current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
        holder.bind(current.getName(), current.getNameimage());
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
