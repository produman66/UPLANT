package edu.example.uplant.ui.adapters.SpravochnikViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;

public class Cartochka7ViewHolder extends RecyclerView.ViewHolder{
    private final TextView wordItemView;
    private final TextView wordDesk;
    private final TextView zag;
    private final ImageView image;

    public Cartochka7ViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.infotext1);
        image = itemView.findViewById(R.id.info_image1);
        wordDesk = itemView.findViewById(R.id.infotext2);
        zag = itemView.findViewById(R.id.infotext10);
    }
    public void bind1(String text, String text1, String text2) {
        wordItemView.setText(text);
        wordDesk.setText(text2);
        zag.setText("Защита");
        int imageResId = itemView.getContext().getResources().getIdentifier(text1, "drawable", itemView.getContext().getPackageName());
        image.setImageResource(imageResId);
    }
    public static Cartochka7ViewHolder create1(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_image, parent, false);
        return new Cartochka7ViewHolder(view);
    }
}
