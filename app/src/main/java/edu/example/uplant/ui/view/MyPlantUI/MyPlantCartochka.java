package edu.example.uplant.ui.view.MyPlantUI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.MyPlantAdapter.PagerMyPlantAdapter;
import edu.example.uplant.ui.view_models.MyPlantViewModel.PagerMyPlantViewModel;

public class MyPlantCartochka extends Fragment {
    PagerMyPlantViewModel mViewModel;
    private static final String STR_VALUE_KEY = "key";
    private int mStrValue;
    PagerMyPlantAdapter adapter;

    public static MyPlantCartochka newInstance(int strValue) {
        MyPlantCartochka fragment = new MyPlantCartochka();
        Bundle args = new Bundle();
        args.putInt(STR_VALUE_KEY, strValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_plant_cartochka, container, false);
        mStrValue = getArguments().getInt(STR_VALUE_KEY);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler61);
        adapter = new PagerMyPlantAdapter(new PagerMyPlantAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new PagerMyPlantViewModel(activity.getApplication(), mStrValue);
            }
        }).get(PagerMyPlantViewModel.class);
        mViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        return view;
    }
}