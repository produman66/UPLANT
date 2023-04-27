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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.room.entites.Plant;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.PlantListAdapter;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.PlantViewModel;

public class MyPlantCategory extends Fragment implements CustomerClickListener {
    private PlantViewModel mWordViewModel;
    PlantListAdapter adapter;
    Fragment fragment12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_category, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler12);
        adapter = new PlantListAdapter(new PlantListAdapter.PlantDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mWordViewModel = new ViewModelProvider(this).get(PlantViewModel.class);
        mWordViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        Toolbar toolbar = view.findViewById(R.id.toolbar12);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Категории растений");
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        return view;
    }
    @Override
    public void onCustomerClick(int position) {
        Plant selectedPlant = adapter.getCurrentList().get(position);
        Fragment fragment = new MyPlantAllPlants();
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getWord());
        args.putInt("key1", selectedPlant.getId());
        fragment.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null); // Добавляем транзакцию в backstack
        transaction.commit();
    }
}