package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.NapPlantModel;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;

public class MyPlantTodoInfoViewHolder extends RecyclerView.ViewHolder {


    private final TextView name;
    private final TextView desc;
    private final TextView date;
    private final TextView time;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    SimpleDateFormat stf = new SimpleDateFormat("HH:mm", Locale.getDefault());


    public MyPlantTodoInfoViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.addname);
        desc = itemView.findViewById(R.id.description);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);
    }


    public void bind(String text, String text1, long text4) {
        name.setText(text);
        desc.setText(text1);
        date.setText(sdf.format(text4));
        time.setText(stf.format(text4));
    }

    public static MyPlantTodoInfoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_todo_info, parent, false);
        return new MyPlantTodoInfoViewHolder(view);
    }
}
