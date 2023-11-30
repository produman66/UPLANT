package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.data.data_sources.category.room.entites.NapPlant;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantAddViewHolder;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantNapMainViewHolder;

public class MyPlantNapMainAdapter extends ListAdapter<NapPlantModel, MyPlantNapMainViewHolder> {
    private CustomerClickListener listener;
    private ButtonClickListener btnlistener;


    public MyPlantNapMainAdapter(@NonNull DiffUtil.ItemCallback<NapPlantModel> diffCallback, CustomerClickListener listener, ButtonClickListener btnlistener) {
        super(diffCallback);
        this.listener = listener;
        this.btnlistener = btnlistener;
    }


    @NonNull
    @Override
    public MyPlantNapMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyPlantNapMainViewHolder.create(parent, listener, btnlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlantNapMainViewHolder holder, int position) {
        NapPlantModel current = getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCustomerClick(position);
            }
        });
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
