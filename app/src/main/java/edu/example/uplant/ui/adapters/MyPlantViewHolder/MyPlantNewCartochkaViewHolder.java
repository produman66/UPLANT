package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;

public class MyPlantNewCartochkaViewHolder extends RecyclerView.ViewHolder{
    private final TextView wordItemView;
    private final TextView wordDesk;
    private final TextView wordPoliv;
    private final TextView wordPeresad;
    private final TextView wordUdobr;
    private final ImageView image;

    public MyPlantNewCartochkaViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.infotext1);
        image = itemView.findViewById(R.id.info_image1);
        wordDesk = itemView.findViewById(R.id.infotext2);
        wordPoliv = itemView.findViewById(R.id.infotext3);
        wordPeresad = itemView.findViewById(R.id.infotext4);
        wordUdobr = itemView.findViewById(R.id.infotext5);
    }
    public void bind1(String text, String text1, String text2, String text3, String text4, String text5) {
        wordItemView.setText(text);
        wordDesk.setText(text2);
        wordPoliv.setText(text3);
        wordPeresad.setText(text4);
        wordUdobr.setText(text5);
        int imageResId = itemView.getContext().getResources().getIdentifier(text1, "drawable", itemView.getContext().getPackageName());
        image.setImageResource(imageResId);
    }
    public static MyPlantNewCartochkaViewHolder create1(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_add_myplant, parent, false);
        return new MyPlantNewCartochkaViewHolder(view);
    }
}
