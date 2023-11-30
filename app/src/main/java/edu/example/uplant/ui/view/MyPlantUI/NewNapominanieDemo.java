package edu.example.uplant.ui.view.MyPlantUI;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import edu.example.uplant.R;
import edu.example.uplant.databinding.FragmentNewNapominanieDemoBinding;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class NewNapominanieDemo extends Fragment {
    FragmentNewNapominanieDemoBinding mBinding;
    NewNapominaieViewModel mViewModel;
    private FirebaseAuth mAuth;
    String idemail;
    int id, idcateg;
    UUID DEM;
    String name, name1;
    String desc;
    long date;
    Calendar dateAndTime = Calendar.getInstance();
    Calendar minDateAndTime = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    SimpleDateFormat stf = new SimpleDateFormat("HH:mm", Locale.getDefault());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentNewNapominanieDemoBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
//        View view = inflater.inflate(R.layout.fragment_new_napominanie_demo, container, false);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        idemail = user.getEmail();

//        Toolbar toolbar = view.findViewById(R.id.toolbar13);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mBinding.toolbar13);
        Drawable icon = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_green_24);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.green_600));
        mBinding.toolbar13.setNavigationIcon(icon);
        mBinding.toolbar13.setNavigationOnClickListener(new View.OnClickListener() {
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
        Bundle args = getArguments();
        name1 = args.getString("key");

        mViewModel = new ViewModelProvider(this).get(NewNapominaieViewModel.class);

        mBinding.editDate.setText(sdf.format(dateAndTime.getTime()));
        mBinding.editTime.setText(stf.format(dateAndTime.getTime()));



        DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateAndTime.set(Calendar.YEAR, year);
                dateAndTime.set(Calendar.MONTH, monthOfYear);
                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Date formatDate = dateAndTime.getTime();
                mBinding.editDate.setText(sdf.format(formatDate));
            }
        };

        TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateAndTime.set(Calendar.MINUTE, minute);
                Date formatDate = dateAndTime.getTime();
                mBinding.editTime.setText(stf.format(formatDate));
            }
        };

        mBinding.editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(minDateAndTime.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        mBinding.editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(getContext(), t,
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE), true)
                        .show();
            }
        });


        mBinding.editName.setText(name1);
        DEM = UUID.randomUUID();
        id = DEM.hashCode();
        mBinding.addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = dateAndTime.getTimeInMillis();
                name = mBinding.editName.getText().toString();
                desc = mBinding.editDesc.getText().toString();
                idcateg = args.getInt("key1");
                if (!mBinding.editDate.getText().toString().equals("") & !name.equals("") & !desc.equals("")) {
                    mViewModel.addNapPlant(id, idemail, idcateg, name, desc, date);
                    Navigation.findNavController(view).navigate(R.id.action_global_myPlantFragment);
                    Toast.makeText(getContext(), "Напоминание добавлено", Toast.LENGTH_LONG).show();
                } else if (mBinding.editDate.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Выберете время и дату", Toast.LENGTH_LONG).show();
                } else if (name.equals("")){
                    Toast.makeText(getContext(), "Зполните имя", Toast.LENGTH_LONG).show();
                } else if (desc.equals("")) {
                    Toast.makeText(getContext(), "Зполните описание", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}