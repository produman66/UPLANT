package edu.example.uplant.ui.view.FavoriteUI;

import android.content.Context;
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
import edu.example.uplant.ui.view.MyPlantUI.MyPlantMain;
import edu.example.uplant.ui.ProfileMain;
import edu.example.uplant.ui.view.SpravochnikUI.PagerFragment;
import edu.example.uplant.ui.view.SpravochnikUI.SpravochnikMain;
import edu.example.uplant.ui.view_models.FavoriteViewModel.FavoriteViewModel;
import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.FavoriteAdapters.FavoriteAdapter;

public class FavoriteMain extends Fragment implements CustomerClickListener {
    private Context context;
    Fragment fragment13;
    private FavoriteViewModel mWordViewModel;
    FavoriteAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler7);
        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Избранное");
        adapter = new FavoriteAdapter(new FavoriteAdapter.PlantDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mWordViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        mWordViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        bottomNavigationView.setSelectedItemId(R.id.favorite);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.plant:
                    fragment13 = new MyPlantMain();
                    FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                    transaction1.replace(R.id.container, fragment13).addToBackStack(null);
                    transaction1.commit();
                    return true;
                case R.id.book:
                    fragment13 = new SpravochnikMain();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment13).addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.favorite:
                    return true;
                case R.id.profile1:
                    fragment13 = new ProfileMain();
                    FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                    transaction2.replace(R.id.container, fragment13).addToBackStack(null);
                    transaction2.commit();
                    return true;
            }
            return false;
        });
        return view;
    }
    public void onCustomerClick(int position) {
        MyPlant selectedPlant = adapter.getCurrentList().get(position);
        Fragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getmWord1());
        fragment.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null); // Добавляем транзакцию в backstack
        transaction.commit();
    }
}