package edu.example.uplant.ui.view.MyPlantUI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.ButtonClickListener;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantNapMainAdapter;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantTodoInfoAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.NewNapominaieViewModel;

public class MyPlantInfoTodo extends Fragment{

    NewNapominaieViewModel mWordViewModel;
    MyPlantTodoInfoAdapter adapter;
    public static MyPlantInfoTodo newInstance(int strValue) {
        MyPlantInfoTodo fragment = new  MyPlantInfoTodo();
        Bundle args = new Bundle();
        args.putInt("key", strValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_plant_info_todo, container, false);


        Toolbar toolbar = view.findViewById(R.id.toolbar14);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Информация о задании");
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });

        int id = getArguments().getInt("key");


        RecyclerView recyclerView = view.findViewById(R.id.recyclerInfoTodo);
        adapter = new MyPlantTodoInfoAdapter(new MyPlantTodoInfoAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mWordViewModel = new ViewModelProvider(this).get(NewNapominaieViewModel.class);
        mWordViewModel.getInfoTodo(id).observe(getActivity(), words -> {
            adapter.submitList(words);
        });


        return view;


    }
}