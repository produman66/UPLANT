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
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantOpisAdapter;
import edu.example.uplant.ui.adapters.MyPlantViewHolder.MyPlantOpisViewHolder;
import edu.example.uplant.ui.view_models.MyPlantViewModel.MyPlantOpisViewModel;

public class MyPlantOpisEdit extends Fragment {
    MyPlantOpisViewModel mViewModel;
    private static final String STR_VALUE_KEY = "key";
    private static final String MyNamePlant = "key1";
    private String name, nameimage;
    private String MyName;
    private FirebaseAuth mAuth;


    MyPlantOpisAdapter adapter;
    Toolbar toolbar;
    String desc;
    String poliv;
    String perec;
    String udobr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_opis_edit, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        toolbar = view.findViewById(R.id.toolbar24);
        activity.setSupportActionBar(toolbar);


        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        activity.getSupportActionBar().setTitle("Добавить Описание");
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });


        name = getArguments().getString(STR_VALUE_KEY);
        MyName = getArguments().getString(MyNamePlant);
        nameimage = getArguments().getString("key2");

        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler26);
        adapter = new MyPlantOpisAdapter(new MyPlantOpisAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MyPlantOpisViewModel(activity.getApplication());
            }
        }).get(MyPlantOpisViewModel.class);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String email = user.getEmail();
        mViewModel.getAllWords(name, email).observe(getActivity(), words -> {
            adapter.submitList(words);
        });

        Button btn = view.findViewById(R.id.btnadd2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    View child = recyclerView.getChildAt(i);
                    MyPlantOpisViewHolder viewHolder = (MyPlantOpisViewHolder) recyclerView.getChildViewHolder(child);
                    desc = viewHolder.wordDesk.getText().toString();
                    poliv = viewHolder.wordPoliv.getText().toString();
                    perec = viewHolder.wordPeresad.getText().toString();
                    udobr = viewHolder.wordUdobr.getText().toString();
                }
                Bundle args = new Bundle();
                args.putString("name", MyName);
                args.putString("desc", desc);
                args.putString("poliv", poliv);
                args.putString("perec", perec);
                args.putString("udobr", udobr);
                args.putString("key", name);
                args.putString("key1", nameimage);
                NavController navController = NavHostFragment.findNavController(MyPlantOpisEdit.this);
                navController.navigate(R.id.action_myPlantOpisEdit2_to_myPlantZametkyEdit2, args);
            }
        });
        return view;
    }
}