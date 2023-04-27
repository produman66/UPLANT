package edu.example.uplant.ui.view.SpravochnikUI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.example.uplant.R;
import edu.example.uplant.data.data_sources.category.room.entites.Plant;
import edu.example.uplant.ui.view.FavoriteUI.FavoriteMain;
import edu.example.uplant.ui.view.MyPlantUI.MyPlantMain;
import edu.example.uplant.ui.ProfileMain;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.PlantListAdapter;
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
                    fragment12 = new MyPlantMain();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment12).addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.book:
                    return true;
                case R.id.favorite:
                    fragment12 = new FavoriteMain();
                    FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                    transaction1.replace(R.id.container, fragment12).addToBackStack(null);
                    transaction1.commit();
                    return true;
                case R.id.profile1:
                    fragment12 = new ProfileMain();
                    FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                    transaction2.replace(R.id.container, fragment12).addToBackStack(null);
                    transaction2.commit();
                    return true;
            }
            return false;
        });
        return view;
    }
    @Override
    public void onCustomerClick(int position) {
        Plant selectedPlant = adapter.getCurrentList().get(position);
        Fragment fragment = new SpravochnicSearch();
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