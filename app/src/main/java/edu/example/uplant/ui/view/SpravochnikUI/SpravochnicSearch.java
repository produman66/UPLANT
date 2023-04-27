package edu.example.uplant.ui.view.SpravochnikUI;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.example.uplant.data.data_sources.category.room.entites.MyPlant;
import edu.example.uplant.R;
import edu.example.uplant.ui.adapters.CustomerClickListener;
import edu.example.uplant.ui.adapters.SpravochnikAdapters.MyPlantListAdapter;
import edu.example.uplant.ui.view_models.SpravochnikViewModel.MyPlantViewModel;


public class SpravochnicSearch extends Fragment implements CustomerClickListener {
    Toolbar toolbar;
    MyPlantViewModel mViewModel;
    MyPlantListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spravochnic_search, container, false);
        Bundle args = getArguments();
        String strValue = args.getString("key");
        toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        RecyclerView recyclerView = view.findViewById(R.id.plantrecycler);
        adapter = new MyPlantListAdapter(new MyPlantListAdapter.PlantDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Drawable icon = getResources().getDrawable(R.drawable.arrow_back);
        DrawableCompat.setTint(icon, ContextCompat.getColor(getActivity(), R.color.white));
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MyPlantViewModel(getActivity().getApplication(), args.getInt("key1"));
            }
        }).get(MyPlantViewModel.class);
        activity.getSupportActionBar().setTitle(strValue);
        mViewModel.getAllWords().observe(getActivity(), words -> {
            adapter.submitList(words);
        });
        return view;
    }
    @Override
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