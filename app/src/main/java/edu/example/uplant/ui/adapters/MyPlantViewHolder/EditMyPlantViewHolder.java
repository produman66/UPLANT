package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;

public class EditMyPlantViewHolder extends RecyclerView.ViewHolder{
    public final EditText Name;
    public final EditText Zamet;
    public final EditText wordDesk;
    public final EditText Poliv;
    public final EditText Peres;
    public final EditText Udobr;
    public final ImageView image;
    String nameImage;
    public EditMyPlantViewHolder(@NonNull View itemView) {
        super(itemView);
        Name = itemView.findViewById(R.id.infotext11);
        image = itemView.findViewById(R.id.info_image10);
        Zamet = itemView.findViewById(R.id.infotext12);
        wordDesk = itemView.findViewById(R.id.infotext13);
        Poliv = itemView.findViewById(R.id.infotext14);
        Peres = itemView.findViewById(R.id.infotext15);
        Udobr = itemView.findViewById(R.id.infotext16);
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
        nameImage = text;
    }
    public static EditMyPlantViewHolder create1(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_myplant_all_edit, parent, false);
        return new EditMyPlantViewHolder(view);
    }

}
