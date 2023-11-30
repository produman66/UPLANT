package edu.example.uplant.ui.adapters.MyPlantAdapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.example.uplant.data.data_sources.category.models.MyPlantModel;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantNewCartochkaViewHolder;

public class MyPlantNewCartochkaAdapter extends ListAdapter<MyPlantModel, MyPlantNewCartochkaViewHolder> {


    public MyPlantNewCartochkaAdapter(@NonNull DiffUtil.ItemCallback<MyPlantModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyPlantNewCartochkaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyPlantNewCartochkaViewHolder.create1(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlantNewCartochkaViewHolder holder, int position) {
        MyPlantModel current = getItem(position);
        holder.bind1(current.getPlantname(), current.getNameimage(), current.getDescrplant(), current.getPolivplant(), current.getPeresadkaplant(), current.getUdobrplant());
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
