package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.SpravochnikViewHolder.CartochkaViewHolder;

public class PagerMyPlantViewHolder extends RecyclerView.ViewHolder{
    private final TextView Name;
    private final TextView Zamet;
    private final TextView wordDesk;
    private final TextView Poliv;
    private final TextView Peres;
    private final TextView Udobr;
    private final ImageView image;
    public PagerMyPlantViewHolder(@NonNull View itemView) {
        super(itemView);
        Name = itemView.findViewById(R.id.infotext1);
        image = itemView.findViewById(R.id.info_image1);
        Zamet = itemView.findViewById(R.id.infotext0);
        wordDesk = itemView.findViewById(R.id.infotext2);
        Poliv = itemView.findViewById(R.id.infotext3);
        Peres = itemView.findViewById(R.id.infotext4);
        Udobr = itemView.findViewById(R.id.infotext5);
    }
    public void bind1(String text, String text1, String text2, String text3, String text4, String text5, String text6) {
        Name.setText(text);
        wordDesk.setText(text2);
        int imageResId = itemView.getContext().getResources().getIdentifier(text1, "drawable", itemView.getContext().getPackageName());
        image.setImageResource(imageResId);
        Zamet.setText(text3);
        Poliv.setText(text4);
        Peres.setText(text5);
        Udobr.setText(text6);
    }
    public static PagerMyPlantViewHolder create1(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_myplant_first, parent, false);
        return new PagerMyPlantViewHolder(view);
    }

}
