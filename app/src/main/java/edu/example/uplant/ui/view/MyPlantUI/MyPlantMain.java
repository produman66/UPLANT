package edu.example.uplant.ui.view.MyPlantUI;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.example.uplant.data.data_sources.category.room.entites.AddPlant;
import edu.example.uplant.R;
import edu.example.uplant.ui.view.FavoriteUI.FavoriteMain;
import edu.example.uplant.ui.ProfileMain;
import edu.example.uplant.ui.view.SpravochnikUI.SpravochnicSearch;
import edu.example.uplant.ui.view.SpravochnikUI.SpravochnikMain;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.MyPlantAdapter.MyPlantAddAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.MyPlantAddViewModel;

public class MyPlantMain extends Fragment implements CustomerClickListener {
    private BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    MyPlantAddViewModel mWordViewModel;
    MyPlantAddAdapter adapter;
    Fragment fragment11;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_main, container, false);

        //Добавляем тулбар
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottonNavigation);
        toolbar = view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Мои растения");


        //Работаем с кнопкой
        ImageView cartinka = view.findViewById(R.id.add1);
        cartinka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment11 = new MyPlantCategory();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment11).addToBackStack(null);
                transaction.commit();
            }
        });



        //Работаем с RecycleView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerAdd);
        adapter = new MyPlantAddAdapter(new MyPlantAddAdapter.PlantDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mWordViewModel = new ViewModelProvider(this).get(MyPlantAddViewModel.class);
        mWordViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        bottomNavigationView.setSelectedItemId(R.id.plant);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.plant:
                    return true;
                case R.id.book:
                    fragment11 = new SpravochnikMain();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment11).addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.favorite:
                    fragment11 = new FavoriteMain();
                    FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                    transaction1.replace(R.id.container, fragment11).addToBackStack(null);
                    transaction1.commit();
                    return true;
                case R.id.profile1:
                    fragment11 = new ProfileMain();
                    FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
                    transaction2.replace(R.id.container, fragment11).addToBackStack(null);
                    transaction2.commit();
                    return true;
            }
            return false;
        });
        return view;
    }
    @Override
    public void onCustomerClick(int position) {
        AddPlant selectedPlant = adapter.getCurrentList().get(position);
        Fragment fragment = new PagerMyPlant();
        Bundle args = new Bundle();
        args.putString("key", selectedPlant.getName());
        args.putInt("key1", selectedPlant.getId());
        args.putString("key2", selectedPlant.getDesc());
        args.putString("key3", selectedPlant.getPoliv());
        args.putString("key4", selectedPlant.getPeresad());
        args.putString("key5", selectedPlant.getUdobr());
        args.putString("key6", selectedPlant.getZametky());
        args.putString("key7", selectedPlant.getNameimage());
        fragment.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null); // Добавляем транзакцию в backstack
        transaction.commit();
    }

}







































