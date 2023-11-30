package edu.example.uplant.ui.view.SpravochnikUI;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.models.PlantModel;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.PlantListAdapter;
import edu.example.uplant.ui.view.MyPlantUI.MyPlantMain;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.PlantViewModel;

public class SpravochnikMain extends Fragment implements CustomerClickListener {
    private PlantViewModel mWordViewModel;
    PlantListAdapter adapter;
    Fragment fragment12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spravochnik_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler1);
        adapter = new PlantListAdapter(new PlantListAdapter.PlantDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mWordViewModel = new ViewModelProvider(this).get(PlantViewModel.class);
        mWordViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        bottomNavigationView.setSelectedItemId(R.id.book);
        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Справочник");
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.plant:
                    Navigation.findNavController(view).navigate(R.id.action_global_myPlantFragment);
                    return true;
                case R.id.book:
                    return true;
                case R.id.favorite:
                    Navigation.findNavController(view).navigate(R.id.action_global_favoriteFragment);
                    return true;
                case R.id.profile1:
                    Navigation.findNavController(view).navigate(R.id.action_global_profileFragment);
                    return true;
            }
            return false;
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(view).navigate(R.id.action_global_myPlantFragment);
            }
        });
        return view;
    }
    @Override
    public void onCustomerClick(int position) {
        PlantModel selectedPlant = adapter.getCurrentList().get(position);
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getName());
        args.putInt("key1", selectedPlant.getId());
        NavController navController = NavHostFragment.findNavController(SpravochnikMain.this);
        navController.navigate(R.id.action_spravochnikMain2_to_spravochnicSearch2, args);
    }
}