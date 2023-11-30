package edu.example.uplant.ui.view.MyPlantUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.UUID;

import edu.example.uplant.R;

import edu.example.uplant.ui.view_models.MyPlantViewModel.AddPlantViewModel;

public class MyPlantZametkyEdit extends Fragment {
    public FirebaseAuth mAuth;
    public String desc, poliv, peresad, udobr, name, nameOriginal, ImageOriginal;
    UUID DEM;
    int id;
    EditText text;
    Toolbar toolbar;
    Button button;
    AddPlantViewModel mViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_zametky_e, container, false);
        mAuth = FirebaseAuth.getInstance();
        text = view.findViewById(R.id.zametky);
        desc = getArguments().getString("desc");
        poliv = getArguments().getString("poliv");
        peresad = getArguments().getString("perec");
        udobr = getArguments().getString("udobr");
        name = getArguments().getString("name");
        nameOriginal = getArguments().getString("key");
        ImageOriginal = getArguments().getString("key1");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        toolbar = view.findViewById(R.id.toolbar29);
        activity.setSupportActionBar(toolbar);
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        activity.getSupportActionBar().setTitle("Добавление заметок");
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });


        mViewModel = new ViewModelProvider(this).get(AddPlantViewModel.class);


        button = view.findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = mAuth.getCurrentUser();
                String email = user.getEmail();
                DEM = UUID.randomUUID();
                id = DEM.hashCode();
                String zametky = String.valueOf(text.getText());
                mViewModel.addPlant(id, email, name, desc, poliv, peresad, udobr, ImageOriginal, zametky);
                NavController navController = NavHostFragment.findNavController(MyPlantZametkyEdit.this);
                navController.navigate(R.id.action_myPlantZametkyEdit2_to_myPlantMain2);
                Toast.makeText(getActivity().getApplicationContext(), "Растение добавлено", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}