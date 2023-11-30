package edu.example.uplant.ui.adapters.MyPlantViewHolder;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Locale;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.CustomerClickListener;

public class MomentInfoViewHolder extends RecyclerView.ViewHolder {

    private final ImageView imageView;
    private final TextView desc;
    private final TextView date;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

    public MomentInfoViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.moment);
        desc = itemView.findViewById(R.id.description);
        date = itemView.findViewById(R.id.date);
    }

    public void bind(String url, String desc1, long time) {
        String imagePath = url;
        Uri imageUri = Uri.parse(imagePath);
        Picasso.get().load(imageUri).into(imageView);
        desc.setText(desc1);
        date.setText(sdf.format(time));
    }

    public static MomentInfoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info_moment, parent, false);
        return new MomentInfoViewHolder(view);
    }
}
