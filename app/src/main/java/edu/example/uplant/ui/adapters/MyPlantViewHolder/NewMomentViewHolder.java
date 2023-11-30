package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;

public class NewMomentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private CustomerClickListener listener;
    private ButtonClickListener btnlistener;
    private final ImageView imageView;

    public NewMomentViewHolder(@NonNull View itemView, CustomerClickListener listener, ButtonClickListener btnlistener) {
        super(itemView);
        imageView = itemView.findViewById(R.id.moment);
        this.listener = listener;
        this.btnlistener = btnlistener;
        itemView.setOnClickListener(this);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    btnlistener.onButtonClick(getAdapterPosition());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onCustomerClick(getAdapterPosition());
        }
    }

    public void bind(String text) {
        String imagePath = text;
        Uri imageUri = Uri.parse(imagePath);
        Picasso.get().load(imageUri).into(imageView);
    }

    public static NewMomentViewHolder create(ViewGroup parent, CustomerClickListener listener, ButtonClickListener btnlistener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_moment, parent, false);
        return new NewMomentViewHolder(view, listener, btnlistener);
    }
}
