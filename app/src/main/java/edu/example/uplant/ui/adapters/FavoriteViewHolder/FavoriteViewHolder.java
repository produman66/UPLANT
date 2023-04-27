package edu.example.uplant.ui.adapters.FavoriteViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.CustomerClickListener;

public class FavoriteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private CustomerClickListener listener;
    private final TextView wordItemView;
    private final ImageView image;
    public FavoriteViewHolder(@NonNull View itemView, CustomerClickListener listener) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.infotext);
        image = itemView.findViewById(R.id.info_image);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onCustomerClick(getAdapterPosition());
        }
    }
    public void bind(String text, String text1) {
        wordItemView.setText(text);
        int imageResId = itemView.getContext().getResources().getIdentifier(text1, "drawable", itemView.getContext().getPackageName());
        image.setImageResource(imageResId);
    }
    public static FavoriteViewHolder create(ViewGroup parent, CustomerClickListener listener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new FavoriteViewHolder(view, listener);
    }
}
