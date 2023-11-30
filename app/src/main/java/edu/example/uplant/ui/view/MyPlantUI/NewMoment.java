package edu.example.uplant.ui.view.MyPlantUI;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;


import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentNewMomentBinding;
import edu.example.uplant.databinding.FragmentNewNapominanieDemoBinding;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewMomentViewModel;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class NewMoment extends Fragment {

    private final int PICK_IMAGE_REQUEST = 1;
    NewMomentViewModel mViewModel;
    int id, idcateg;
    String idemail;
    UUID DEM;
    String desc, mediaURL = "", date;
    long time;
    Calendar dateAndTime = Calendar.getInstance();
    Calendar minDateAndTime = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    FragmentNewMomentBinding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentNewMomentBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mBinding.toolbar14);
        Drawable icon = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_green_24);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.green_600));
        mBinding.toolbar14.setNavigationIcon(icon);
        mBinding.toolbar14.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mViewModel = new ViewModelProvider(this).get(NewMomentViewModel.class);

        mBinding.noteImage.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
            startActivityForResult(
                    Intent.createChooser(
                            intent,
                            "Select Image from here..."),
                    PICK_IMAGE_REQUEST);
        });

        mBinding.addTask.setOnClickListener(v -> {
            Bundle args = getArguments();
            idcateg = getArguments().getInt("id");
            DEM = UUID.randomUUID();
            id = DEM.hashCode();
            desc = mBinding.editDesc.getText().toString();
            Date currentDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            date = sdf.format(currentDate);
            time = currentDate.getTime();
            if (!desc.equals("") || !mediaURL.equals("")) {
                mViewModel.addMoment(id, idcateg, desc, date, time, mediaURL);
                Navigation.findNavController(view).popBackStack();
            }
            else
                Toast.makeText(v.getContext(), "Заполните поля", Toast.LENGTH_LONG).show();
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getActivity();
        Uri uri = data.getData();
        if (uri!=null)
            mediaURL = uri.toString();
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data!=null && data.getData()!=null) {
            try {
                Picasso.get()
                        .load(uri)
                        .into(mBinding.noteImage);
            } catch (Exception e) {
                Toast.makeText(getContext(), "Ошибка загрузки фотографии", Toast.LENGTH_LONG).show();
            }
        }
    }

}