package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.example.uplant.R;

public class MyPlantOpisViewHolder extends RecyclerView.ViewHolder {
    public final EditText wordDesk;
    public final EditText wordPoliv;
    public final EditText wordPeresad;
    public final EditText wordUdobr;
    public MyPlantOpisViewHolder(@NonNull View itemView) {
        super(itemView);
        wordDesk = itemView.findViewById(R.id.edittext2);
        wordPoliv = itemView.findViewById(R.id.edittext3);
        wordPeresad = itemView.findViewById(R.id.edittext4);
        wordUdobr = itemView.findViewById(R.id.edittext5);
    }
    public void bind1(String text, String text1, String text2, String text3, String text4, String text5) {
        wordDesk.setText(text2);
        wordPoliv.setText(text3);
        wordPeresad.setText(text4);
        wordUdobr.setText(text5);
    }

    public static MyPlantOpisViewHolder create1(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_opis_edit, parent, false);
        return new MyPlantOpisViewHolder(view);
    }
}
