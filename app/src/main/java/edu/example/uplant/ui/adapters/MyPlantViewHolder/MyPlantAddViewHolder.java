package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.PlantViewHolder;

public class MyPlantAddViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private CustomerClickListener listener;
    private ButtonClickListener btnlistener;
    private final TextView wordItemView;
    private final ImageView image;
    private ImageButton myButton;

    public MyPlantAddViewHolder(@NonNull View itemView, CustomerClickListener listener, ButtonClickListener btnlistener ) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.infotext2);
        image = itemView.findViewById(R.id.info_image2);
        myButton = itemView.findViewById(R.id.select);
        this.btnlistener = btnlistener;
        this.listener = listener;
        itemView.setOnClickListener(this);
        myButton.setOnClickListener(new View.OnClickListener() {
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

    public void bind(String text, String text1) {
        wordItemView.setText(text);
        int imageResId = itemView.getContext().getResources().getIdentifier(text1, "drawable", itemView.getContext().getPackageName());
        image.setImageResource(imageResId);
    }

    public static MyPlantAddViewHolder create(ViewGroup parent, CustomerClickListener listener, ButtonClickListener btnlistener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_myplant_main, parent, false);
        return new MyPlantAddViewHolder(view, listener, btnlistener);
    }
}
