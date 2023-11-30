package edu.example.uplant.ui.view.MyPlantUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantNewCartochkaAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.MyPlantNewCartochkaViewModel;

public class MyPlantNewCartochka extends Fragment {
    MyPlantNewCartochkaViewModel mViewModel;
    private String name, nameimage;
    MyPlantNewCartochkaAdapter adapter;
    Toolbar toolbar;
    private FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_new_cartochka, container, false);
        name = getArguments().getString("key");
        nameimage = getArguments().getString("key1");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler6);
        adapter = new MyPlantNewCartochkaAdapter(new MyPlantNewCartochkaAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        toolbar = view.findViewById(R.id.toolbar22);
        activity.setSupportActionBar(toolbar);
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        activity.getSupportActionBar().setTitle("Добавить растение");
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MyPlantNewCartochkaViewModel(activity.getApplication());
            }
        }).get(MyPlantNewCartochkaViewModel.class);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String email = user.getEmail();
        mViewModel.getAllWords(name, email).observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        Button button = view.findViewById(R.id.btnadd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("key", name);
                args.putString("key1", nameimage);
                NavController navController = NavHostFragment.findNavController(MyPlantNewCartochka.this);
                navController.navigate(R.id.action_myPlantNewCartochka2_to_editNameNewCartochka2, args);
            }
        });
        return view;
    }
}