package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.MomentModel;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.Moment;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantNapMainViewHolder;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.NewMomentViewHolder;

public class NewMomentAdapter extends ListAdapter<MomentModel, NewMomentViewHolder> {
    private CustomerClickListener listener;
    private ButtonClickListener btnlistener;

    public NewMomentAdapter(@NonNull DiffUtil.ItemCallback<MomentModel> diffCallback, CustomerClickListener listener, ButtonClickListener btnlistener) {
        super(diffCallback);
        this.listener = listener;
        this.btnlistener = btnlistener;
    }

    @NonNull
    @Override
    public NewMomentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NewMomentViewHolder.create(parent, listener, btnlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewMomentViewHolder holder, int position) {
        MomentModel current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
        holder.bind(current.getUrl());
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
