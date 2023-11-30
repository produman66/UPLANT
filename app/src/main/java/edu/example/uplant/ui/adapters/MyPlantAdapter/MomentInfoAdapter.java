package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.MomentModel;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MomentInfoViewHolder;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantTodoInfoViewHolder;

public class MomentInfoAdapter extends ListAdapter<MomentModel, MomentInfoViewHolder> {

    public MomentInfoAdapter(@NonNull DiffUtil.ItemCallback<MomentModel> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public MomentInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MomentInfoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MomentInfoViewHolder holder, int position) {
        MomentModel current = getItem(position);
        holder.bind(current.getUrl(), current.getDesc(), current.getTime());
    }

    public static class PlantDiff extends DiffUtil.ItemCallback<MomentModel> {
        @Override
        public boolean areItemsTheSame(@NonNull MomentModel oldItem, @NonNull MomentModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MomentModel oldItem, @NonNull MomentModel newItem) {
            return oldItem.getDesc().equals(newItem.getDesc());
        }
    }
}
