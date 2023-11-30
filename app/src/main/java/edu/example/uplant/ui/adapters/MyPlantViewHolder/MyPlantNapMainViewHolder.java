package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
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

public class MyPlantNapMainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private CustomerClickListener listener;
    private ButtonClickListener btnlistener;
    private final TextView name;
    private final TextView desc;
    private final TextView date;
    private final TextView time;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    SimpleDateFormat stf = new SimpleDateFormat("HH:mm", Locale.getDefault());
    List<NapPlantModel> data;
    private ImageButton myButton;
    public MyPlantNapMainViewHolder(@NonNull View itemView, CustomerClickListener listener, ButtonClickListener btnlistener ) {
        super(itemView);
        name = itemView.findViewById(R.id.addname);
        desc = itemView.findViewById(R.id.description);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);
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

    public void bind(String text, String text1, long text4) {
        name.setText(text);
        desc.setText(text1);
        date.setText(sdf.format(text4));
        time.setText(stf.format(text4));
    }

    public static MyPlantNapMainViewHolder create(ViewGroup parent, CustomerClickListener listener, ButtonClickListener btnlistener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_napominanya, parent, false);
        return new MyPlantNapMainViewHolder(view, listener, btnlistener);
    }
}
