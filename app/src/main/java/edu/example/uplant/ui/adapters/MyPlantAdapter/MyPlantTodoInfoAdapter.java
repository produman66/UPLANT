package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantNapMainViewHolder;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantTodoInfoViewHolder;

public class MyPlantTodoInfoAdapter extends ListAdapter<NapPlantModel, MyPlantTodoInfoViewHolder> {

    public MyPlantTodoInfoAdapter(@NonNull DiffUtil.ItemCallback<NapPlantModel> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public MyPlantTodoInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyPlantTodoInfoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlantTodoInfoViewHolder holder, int position) {
        NapPlantModel current = getItem(position);
        holder.bind(current.getPlantname(), current.getDesc(), current.getTime());
    }

    public static class PlantDiff extends DiffUtil.ItemCallback<NapPlantModel> {
        @Override
        public boolean areItemsTheSame(@NonNull NapPlantModel oldItem, @NonNull NapPlantModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull NapPlantModel oldItem, @NonNull NapPlantModel newItem) {
            return oldItem.getPlantname().equals(newItem.getPlantname());
        }
    }
}
