package edu.example.uplant.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.example.uplant.data.data_sources.category.models.Item;
import edu.example.uplant.databinding.CardCaptionedImageBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewItemViewHolder> {
    List<Item> data;
    public RecyclerViewAdapter() {
        this.data = new ArrayList<>();
    }


    public RecyclerViewAdapter(List<Item> data) {
        this.data = data;
    }

    public void updateData(List<Item> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardCaptionedImageBinding mBinding = CardCaptionedImageBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new RecyclerViewItemViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewItemViewHolder holder, int position) {
        holder.binding.infotext.setText(data.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RecyclerViewItemViewHolder extends RecyclerView.ViewHolder {
        public CardCaptionedImageBinding binding;

        public RecyclerViewItemViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = CardCaptionedImageBinding.bind(itemView);
        }
    }
}